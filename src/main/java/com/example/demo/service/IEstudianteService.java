package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;


public interface IEstudianteService {
	
	public void registrar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public Estudiante encontrar(Integer id);
	
	public void borrar(Integer id);
	
	public Estudiante encontrarEstudiantePorNombre(String nombre);

	public Estudiante encontrarEstudiantePorApellido(String apellido);

	List<Estudiante> encontrarTodos();
	
	List<Estudiante> encontrarTodosPorSalario(BigDecimal salario);

	List<EstudianteTO> encontrarTodosTO();
}
