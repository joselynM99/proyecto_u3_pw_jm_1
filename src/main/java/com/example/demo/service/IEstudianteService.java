package com.example.demo.service;

import com.example.demo.modelo.Estudiante;


public interface IEstudianteService {
	
	public void registrar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public Estudiante encontrar(Integer id);
	
	public void borrar(Integer id);
	
	public Estudiante encontrarEstudiantePorNombre(String nombre);

	public Estudiante encontrarEstudiantePorApellido(String apellido);

}
