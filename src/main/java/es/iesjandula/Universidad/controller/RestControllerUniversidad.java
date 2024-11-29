package es.iesjandula.Universidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.Universidad.dto.MatriculaDto;
import es.iesjandula.Universidad.models.Alumno;
import es.iesjandula.Universidad.models.Asignatura;
import es.iesjandula.Universidad.models.Curso;
import es.iesjandula.Universidad.models.Matricula;
import es.iesjandula.Universidad.models.MatriculaId;
import es.iesjandula.Universidad.repository.AlumnoRepository;
import es.iesjandula.Universidad.repository.AsignaturaRepository;
import es.iesjandula.Universidad.repository.CursoRepository;
import es.iesjandula.Universidad.repository.MatriculaRepository;
import es.iesjandula.Universidad.utils.UniversidadServerError;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/universidad")
@Slf4j
public class RestControllerUniversidad
{
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private MatriculaRepository matriculaRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/matricular")
	public ResponseEntity<?> matricularAlumno(@RequestBody(required = true) MatriculaDto matriculaRequest)
	{
		try
		{
			HttpStatus httpStatus = HttpStatus.CREATED;

			Long alumnoId = matriculaRequest.getAlumnoId();
			Long cursoId = matriculaRequest.getCursoId();
			Long asignaturaId = matriculaRequest.getAsignaturaId();

			Alumno alumno = this.alumnoRepository.findById(alumnoId).get();

			Curso curso = this.cursoRepository.findById(cursoId).get();

			Asignatura asignatura = this.asignaturaRepository.findById(asignaturaId).get();

			String message = "Alumno matriculado correctamente";

			if (alumno != null && asignatura != null && curso != null)
			{
				MatriculaId matriculaId = new MatriculaId(alumnoId, asignaturaId, cursoId);

				if (!(this.matriculaRepository.findById(matriculaId).isPresent()))
				{
					Matricula matricula = new Matricula(matriculaId, alumno, asignatura, curso);

					this.matriculaRepository.saveAndFlush(matricula);
				}
				else
				{
					message = "Matricula ya existente";
					httpStatus = httpStatus.BAD_REQUEST;
				}
			}
			else
			{
				message = "El alumno no se ha podido matricular";
				throw new UniversidadServerError(0, message);
			}

			return ResponseEntity.status(httpStatus).body(message);
		}
		catch (Exception exception)
		{
			String message = "Fallo en el servidor";
			UniversidadServerError universidadServerError = new UniversidadServerError(1, message);
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(universidadServerError.getMapError());
		}
	}
}
