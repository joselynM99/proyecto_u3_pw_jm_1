package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
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
	public Estudiante encontrar(Integer id) {
		return this.estudianteRepository.buscar(id);
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

}
