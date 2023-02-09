package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return myQuery.getResultList();

	}
	
	@Override
	public List<Estudiante> buscarTodosPorSalario(BigDecimal salario) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.salario>=:salario", Estudiante.class);
		myQuery.setParameter("salario", salario);
		return myQuery.getResultList();

	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estu = this.buscar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante buscarEstudiantePorNombre(String nombre) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.nombre=:nombre", Estudiante.class);
		myQuery.setParameter("nombre", nombre);

		return myQuery.getSingleResult();

	}

	@Override
	public Estudiante buscarEstudiantePorApellido(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.apellido=:apellido", Estudiante.class);
		myQuery.setParameter("apellido", apellido);

		return myQuery.getSingleResult();

	}

}
