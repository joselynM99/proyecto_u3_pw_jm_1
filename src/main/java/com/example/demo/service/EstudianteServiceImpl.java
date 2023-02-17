package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.service.to.EstudianteNuevoTO;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void registrar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public EstudianteNuevoTO encontrar(Integer id) {
		return this.convertirNuevoTO(this.estudianteRepository.buscar(id));
	}

	@Override
	public List<Estudiante> encontrarTodos() {
		return this.estudianteRepository.buscarTodos();
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepository.eliminar(id);

	}

	@Override
	public Estudiante encontrarEstudiantePorNombre(String nombre) {
		return this.estudianteRepository.buscarEstudiantePorNombre(nombre);
	}

	@Override
	public Estudiante encontrarEstudiantePorApellido(String apellido) {
		return this.estudianteRepository.buscarEstudiantePorApellido(apellido);
	}

	@Override
	public List<Estudiante> encontrarTodosPorSalario(BigDecimal salario) {
		return this.estudianteRepository.buscarTodosPorSalario(salario);
	}

	@Override
	public List<EstudianteTO> encontrarTodosTO() {
		List<Estudiante> lista = this.estudianteRepository.buscarTodos();
		List<EstudianteTO> listaFinal = lista.stream().map(estudiante -> this.convertir(estudiante))
				.collect(Collectors.toList());
		return listaFinal;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estu = new EstudianteTO();
		estu.setId(estudiante.getId());
		estu.setNombre(estudiante.getNombre());
		estu.setApellido(estudiante.getApellido());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		return estu;
	}
	
	private EstudianteNuevoTO convertirNuevoTO(Estudiante estudiante) {
		EstudianteNuevoTO estu = new EstudianteNuevoTO();
		
		estu.setNombre(estudiante.getNombre());
		estu.setApellido(estudiante.getApellido());
		
		return estu;
	}

}
