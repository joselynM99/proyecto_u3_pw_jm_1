package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Materia;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public List<MateriaTO> buscarPorEstudiante(Integer idEstudiante) {
		List<Materia> lista = this.materiaRepository.buscarPorEstudiante(idEstudiante);
		List<MateriaTO> listaFinal = lista.stream().map(materia -> this.convertir(materia))
				.collect(Collectors.toList());
		return listaFinal;
	}

	

	@Override
	public MateriaTO encontrarMateria(Integer id) {
		return this.convertir(this.materiaRepository.buscarMateria(id));
	}
	
	private MateriaTO convertir(Materia materia) {
		MateriaTO materiaTO = new MateriaTO();
		materiaTO.setId(materia.getId());
		materiaTO.setCreditos(materia.getCreditos());
		materiaTO.setNombre(materia.getNombre());

		return materiaTO;
	}

}
