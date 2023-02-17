package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Materia> buscarPorEstudiante(Integer idEstudiante) {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery(
				"SELECT m FROM Materia m JOIN FETCH m.estudiante e WHERE e.id =:idEstudiante  ", Materia.class);
		myQuery.setParameter("idEstudiante", idEstudiante);
		return myQuery.getResultList();
	}
	
	@Override
	public Materia buscarMateria(Integer id) {
		return this.entityManager.find(Materia.class, id);
	}

}
