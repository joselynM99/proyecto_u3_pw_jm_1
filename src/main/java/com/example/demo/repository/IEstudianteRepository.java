package com.example.demo.repository;

import com.example.demo.modelo.Estudiante;


public interface IEstudianteRepository {
	
	public void insertar(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public Estudiante buscar(Integer id);
	
	public void eliminar(Integer id);

	
	public Estudiante buscarEstudiantePorNombre(String nombre);

	public Estudiante buscarEstudiantePorApellido(String apellido);

}
