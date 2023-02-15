package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	// Ejemplos de Capacidades que reciba un Media Type application/json

//	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public void registrar(@RequestBody Profesor profesor) {
//		this.profesorService.registrar(profesor);
//	}
//
//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public void actualizar(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
//
//		profesor.setId(id);
//		this.profesorService.actualizar(profesor);
//	}

	// Ejemplos de Capacidades que retornen un Media Type application/json

//	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public Profesor encontrar(@PathVariable("id") Integer id) {
//		return this.profesorService.encontrar(id);
//	}
//
//	@GetMapping(path = "/cedula/{cedula}", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public Profesor encontrarProfesorPorCedula(@PathVariable("cedula") String cedula) {
//		return this.profesorService.encontrarPorCedula(cedula);
//	}

	// Ejemplos de Capacidades que reciba un Media Type application/xml

//	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE })
//	public void registrar(@RequestBody Profesor profesor) {
//		this.profesorService.registrar(profesor);
//	}
//
//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE })
//	public void actualizar(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
//
//		profesor.setId(id);
//		this.profesorService.actualizar(profesor);
//	}
//	

	// Ejemplos de Capacidades que retornen un Media Type application/xml

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE })
	public Profesor encontrar(@PathVariable("id") Integer id) {
		return this.profesorService.encontrar(id);
	}

	@GetMapping(path = "/cedula/{cedula}", produces = { MediaType.APPLICATION_XML_VALUE })
	public Profesor encontrarProfesorPorCedula(@PathVariable("cedula") String cedula) {
		return this.profesorService.encontrarPorCedula(cedula);
	}

	// Ejemplos de Capacidades que reciban y retornen un Media Type application/json

//	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<Profesor> registrar(@RequestBody Profesor profesor) {
//		this.profesorService.registrar(profesor);
//		return ResponseEntity.status(HttpStatus.OK).body(profesor);
//	}
//
//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<Profesor> actualizar(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
//		profesor.setId(id);
//		this.profesorService.actualizar(profesor);
//		return ResponseEntity.status(HttpStatus.OK).body(this.profesorService.encontrar(id));
//	}
//
//	@PutMapping
//	public void actualizarTodos(Estudiante estudiante) {
//
//	}

	// Ejemplos de Capacidades que reciban y retornen un Media Type application/json

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Profesor> registrar(@RequestBody Profesor profesor) {
		this.profesorService.registrar(profesor);
		return ResponseEntity.status(HttpStatus.OK).body(profesor);
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Profesor> actualizar(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
		profesor.setId(id);
		this.profesorService.actualizar(profesor);
		return ResponseEntity.status(HttpStatus.OK).body(this.profesorService.encontrar(id));
	}

	@PutMapping
	public void actualizarTodos(Estudiante estudiante) {

	}

//	@GetMapping(path = "/{id}")
//	public Profesor encontrar(@PathVariable("id") Integer id) {
//		return this.profesorService.encontrar(id);
//	}
//
//	@GetMapping(path = "/cedula/{cedula}")
//	public Profesor encontrarProfesorPorCedula(@PathVariable("cedula") String cedula) {
//		return this.profesorService.encontrarPorCedula(cedula);
//	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {

		this.profesorService.eliminar(id);

	}

	@DeleteMapping
	public void borrarTodos() {

	}

	@GetMapping
	public List<Profesor> encontrarTodos() {
		return this.profesorService.encontrarTodos();
	}

}
