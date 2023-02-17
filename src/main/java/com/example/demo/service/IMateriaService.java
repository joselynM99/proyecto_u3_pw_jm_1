package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.MateriaTO;

public interface IMateriaService {

	public List<MateriaTO> buscarPorEstudiante(Integer idEstudiante);
	
	public MateriaTO encontrarMateria(Integer id);

}
