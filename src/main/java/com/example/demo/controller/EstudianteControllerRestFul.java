package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;

	public void registrar(Estudiante estudiante) {

	}

	public void actualizar(Estudiante estudiante) {

	}

	@GetMapping(path = "/buscar/{id}")
	public Estudiante encontrar(@PathVariable("id") Integer id) {
		return this.estudianteService.encontrar(id);
	}
	
	
	@GetMapping(path = "/buscarPorNombre/{nombre}")
	public Estudiante encontrarEstudianteNombre(@PathVariable("nombre") String nombre) {
		return this.estudianteService.encontrarEstudiantePorNombre(nombre);
	}
	
	@GetMapping(path = "/buscarPorApellido/{apellido}")
	public Estudiante encontrarEstudianteApellido(@PathVariable("apellido") String apellido) {
		return this.estudianteService.encontrarEstudiantePorApellido(apellido);
	}

	public void borrar(Integer id) {

	}

}
