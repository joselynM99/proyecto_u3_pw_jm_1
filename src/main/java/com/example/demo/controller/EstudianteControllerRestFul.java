package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteNuevoTO;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	@PostMapping
	public void registrar(@RequestBody Estudiante estudiante) {
		this.estudianteService.registrar(estudiante);
	}

	/*
	 * @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_XML_VALUE})
	 * public void actualizar(@PathVariable("id") Integer id, @RequestBody
	 * Estudiante estudiante,
	 * 
	 * @RequestParam("provincia") String provincia) { estudiante.setId(id);
	 * System.out.println(provincia); this.estudianteService.actualizar(estudiante);
	 * }
	 */

//	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
//			MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<Estudiante> actualizar(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante,
//			@RequestParam("provincia") String provincia) {
//		estudiante.setId(id);
//		System.out.println(provincia);
//		this.estudianteService.actualizar(estudiante);
//		Estudiante estu = this.estudianteService.encontrar(id);
//		return ResponseEntity.status(HttpStatus.OK).body(estu);
//	}

	@PutMapping
	public void actualizarTodos(Estudiante estudiante) {

	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EstudianteNuevoTO> encontrar(@PathVariable("id") Integer id) {

		EstudianteNuevoTO estu = this.estudianteService.encontrar(id);
		return ResponseEntity.status(230).body(estu);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstudianteTO> encontrarTodosHateoas() {
		List<EstudianteTO> lista = this.estudianteService.encontrarTodosTO();
		for (EstudianteTO estu : lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarMaterias(estu.getId()))
					.withRel("materias");
			estu.add(myLink);
			// link a sí mismo
			Link myLink2 = linkTo(methodOn(EstudianteControllerRestFul.class).encontrar(estu.getId())).withSelfRel();
			estu.add(myLink2);

			Link myLink3 = linkTo(EstudianteControllerRestFul.class).slash("prueba").slash("pruebaEstudiante")
					.slash(estu.getId()).withRel("enlace prueba");
			estu.add(myLink3);
		}

		return lista;

	}

	@GetMapping(path = "/{idEstudiante}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO> buscarMaterias(@PathVariable("idEstudiante") Integer idEstudiante) {
		
		List<MateriaTO> lista = this.materiaService.buscarPorEstudiante(idEstudiante);
		
		for(MateriaTO mat :lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarMateria(mat.getId()))
					.withSelfRel();
			mat.add(myLink);
		}
		return lista;

	}
	
	@GetMapping(path = "/materias/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MateriaTO buscarMateria(@PathVariable("id") Integer id) {
		return this.materiaService.encontrarMateria(id);

	}

//	@GetMapping
//	public ResponseEntity<List<Estudiante>> encontrarTodos() {
//		
//		HttpHeaders cabeceras = new HttpHeaders();
//		cabeceras.add("detalleMensaje", "Estudiante encontrado correctamente");
//		cabeceras.add("valorCalculado", "100");
//		List<Estudiante> lista = this.estudianteService.encontrarTodos();
//		return new ResponseEntity<>(lista, cabeceras, 230);
//				
//	}

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
