package es.iesjandula.Universidad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Asignatura;
import es.iesjandula.Universidad.models.Grado;
import es.iesjandula.Universidad.models.Profesor;
import es.iesjandula.Universidad.repository.AsignaturaRepository;
import es.iesjandula.Universidad.repository.GradoRepository;
import es.iesjandula.Universidad.repository.ProfesorRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoAsignatura;
import es.iesjandula.Universidad.utils.UniversidadServerError;

@Service
public class ParseoAsignatura implements IParseoAsignatura
{
	@Autowired
	AsignaturaRepository iAsignaturaRepository;
	
	@Autowired
	ProfesorRepository iProfesorRepository;
	
	@Autowired
	GradoRepository iGradoRepository;

	@Override
	public void parseoAsignaturaCsv(Scanner scanner) throws UniversidadServerError
	{

		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Asignatura> asignaturas = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");

			Asignatura asignatura = new Asignatura();

			asignatura.setId(Long.parseLong(columna[0]));
			asignatura.setNombre(columna[1]);
			asignatura.setCreditos(Double.parseDouble(columna[2]));
			asignatura.setTipo(columna[3]);
			asignatura.setCurso(Integer.parseInt(columna[4]));
			asignatura.setCuatrimestre(Integer.parseInt(columna[5]));
			
			Long profesorId = Long.parseLong(columna[6]);
		    Profesor profesor = iProfesorRepository.findById(profesorId).orElseThrow(() -> new UniversidadServerError(1, "Profesor no encontrado con ID: " + profesorId));
			asignatura.setIdProfesor(profesor);
			
			Long gradoId = Long.parseLong(columna[7]);
			Grado grado = iGradoRepository.findById(gradoId).orElseThrow(() -> new UniversidadServerError(2, "Grado no encontrado con ID: " + gradoId));
			asignatura.setIdGrado(grado);
			
			asignaturas.add(asignatura);
		}
		this.iAsignaturaRepository.saveAllAndFlush(asignaturas);
	}
}
