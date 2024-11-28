package es.iesjandula.Universidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.repository.ProfesorRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ControllerUniversidad
{
	@Autowired
	ProfesorRepository profesorRepository;
	
	@PostConstruct
	public void init()
	{
		log.info(this.profesorRepository.findNifBySexo("H").get(0).getNombre());
	}
}
