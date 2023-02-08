package com.example.demo.repository;

import com.example.demo.modelo.Profesor;


public interface IProfesorRepository {
	
	public void insertar(Profesor profesor);
	
	public void actualizar(Profesor profesor);
	
	public Profesor buscar(Integer id);
	
	public void eliminar(Integer id);

	
	public Profesor buscarPorCedula(String cedula);

	

}
