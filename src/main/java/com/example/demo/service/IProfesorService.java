package com.example.demo.service;

import com.example.demo.modelo.Profesor;


public interface IProfesorService {
	
	public void registrar(Profesor profesor);
	
	public void actualizar(Profesor profesor);
	
	public Profesor encontrar(Integer id);
	
	public void eliminar(Integer id);

	
	public Profesor encontrarPorCedula(String cedula);

	

}