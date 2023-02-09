package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@PostMapping
	public void registrar(@RequestBody Estudiante estudiante) {
		this.estudianteService.registrar(estudiante);
	}

	@PutMapping(path = "/{id}")
	public void actualizar(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante,
			@RequestParam("provincia") String provincia) {
		estudiante.setId(id);
		System.out.println(provincia);
		this.estudianteService.actualizar(estudiante);
	}

	@PutMapping
	public void actualizarTodos(Estudiante estudiante) {

	}

	@GetMapping(path = "/{id}")
	public Estudiante encontrar(@PathVariable("id") Integer id) {
		return this.estudianteService.encontrar(id);
	}

	@GetMapping
	public List<Estudiante> encontrarTodos() {
		return this.estudianteService.encontrarTodos();
	}

	@GetMapping(path = "/salario")
	public List<Estudiante> encontrarTodosPorSalario(@RequestParam("salario") BigDecimal salario) {
		return this.estudianteService.encontrarTodosPorSalario(salario);
	}

	@GetMapping(path = "/buscarPorNombre/{nombre}")
	public Estudiante encontrarEstudianteNombre(@PathVariable("nombre") String nombre) {
		return this.estudianteService.encontrarEstudiantePorNombre(nombre);
	}

	@GetMapping(path = "/buscarPorApellido/{apellido}")
	public Estudiante encontrarEstudianteApellido(@PathVariable("apellido") String apellido) {
		return this.estudianteService.encontrarEstudiantePorApellido(apellido);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {
		this.estudianteService.borrar(id);

	}

	@PostMapping(path = "/borrar/{id}")
	public void borrarTMP(@PathVariable("id") Integer id) {
		this.estudianteService.borrar(id);

	}

	@DeleteMapping
	public void borrarTodos() {

	}

}
