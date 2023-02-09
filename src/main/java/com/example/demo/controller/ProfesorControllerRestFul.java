package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Profesor;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	@PostMapping
	public void registrar(@RequestBody Profesor profesor) {
		this.profesorService.registrar(profesor);
	}

	@PutMapping(path = "/{id}")
	public void actualizar(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {

		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}

	@PutMapping
	public void actualizarTodos(Estudiante estudiante) {

	}

	@GetMapping(path = "/{id}")
	public Profesor encontrar(@PathVariable("id") Integer id) {
		return this.profesorService.encontrar(id);
	}

	@GetMapping(path = "/cedula/{cedula}")
	public Profesor encontrarProfesorPorCedula(@PathVariable("cedula") String cedula) {
		return this.profesorService.encontrarPorCedula(cedula);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {

		this.profesorService.eliminar(id);

	}

	@DeleteMapping
	public void borrarTodos() {

	}

}
