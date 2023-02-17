package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Materia;

public interface IMateriaRepository {
	
	public List<Materia> buscarPorEstudiante(Integer idEstudiante);

	Materia buscarMateria(Integer id);

}
