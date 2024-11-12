package es.iesjandula.Universidad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Alumno;
import es.iesjandula.Universidad.models.Asignatura;
import es.iesjandula.Universidad.models.Curso;
import es.iesjandula.Universidad.models.Matricula;
import es.iesjandula.Universidad.repository.AlumnoRepository;
import es.iesjandula.Universidad.repository.AsignaturaRepository;
import es.iesjandula.Universidad.repository.CursoRepository;
import es.iesjandula.Universidad.repository.MatriculaRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoMatricula;
import es.iesjandula.Universidad.utils.UniversidadServerError;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ParseoMatricula implements IParseoMatricula
{
	@Autowired
	MatriculaRepository iMatriculaRepository;
	
	@Autowired
	AlumnoRepository iAlumnoRepository;
	
	@Autowired
	AsignaturaRepository iAsignaturaRepository;
	
	@Autowired
	CursoRepository iCursoRepository;

	@Override
	public void parseoMatriculaCsv(Scanner scanner) throws UniversidadServerError
	{

		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Matricula> matriculas = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columnas = line.split(",");

			Matricula matricula = new Matricula();

			Long alumnoId = Long.parseLong(columnas[0]);
		    Alumno alumno = iAlumnoRepository.findById(alumnoId).orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con ID: " + alumnoId));
			matricula.setIdAlumno(alumno);
			
			Long asignaturaId = Long.parseLong(columnas[1]);
		    Asignatura asignatura = iAsignaturaRepository.findById(asignaturaId).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada con ID: " + asignaturaId));
		    matricula.setIdAsignatura(asignatura);
			
		    Long cursoId = Long.parseLong(columnas[2]);
		    Curso curso = iCursoRepository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con ID: " + cursoId));
			matricula.setIdCurso(curso);
			
			matriculas.add(matricula);
		}
		this.iMatriculaRepository.saveAllAndFlush(matriculas);
	}
}
