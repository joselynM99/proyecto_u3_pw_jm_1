package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Profesor;
import com.example.demo.repository.IProfesorRepository;

@Service
public class ProfesorServiceImpl implements IProfesorService{
	
	@Autowired
	private IProfesorRepository profesorRepository;

	@Override
	public void registrar(Profesor profesor) {
		this.profesorRepository.insertar(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		this.profesorRepository.actualizar(profesor);
	}

	@Override
	public Profesor encontrar(Integer id) {
		return this.profesorRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.profesorRepository.eliminar(id);
	}

	@Override
	public Profesor encontrarPorCedula(String cedula) {
		return this.profesorRepository.buscarPorCedula(cedula);
	}
	
	@Override
	public List<Profesor> encontrarTodos() {
		return this.profesorRepository.buscarTodos();
	}

}
