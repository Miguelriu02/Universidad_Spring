package es.iesjandula.Universidad.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Alumno;
import es.iesjandula.Universidad.repository.AlumnoRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoAlumno;
import es.iesjandula.Universidad.utils.UniversidadServerError;

@Service
public class ParseoAlumno implements IParseoAlumno
{
	@Autowired
	AlumnoRepository iAlumnoRepository;

	@Override
	public void parseoAlumnoCsv(Scanner scanner) throws UniversidadServerError
	{
		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Alumno> alumnos = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");

			Alumno alumno = new Alumno();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fecha = LocalDate.parse(columna[8], formatter);

			alumno.setId(Long.parseLong(columna[0]));
			alumno.setNif(columna[1]);
			alumno.setNombre(columna[2]);
			alumno.setApellido1(columna[3]);
			alumno.setApellido2(columna[4]);
			alumno.setCiudad(columna[5]);
			alumno.setDireccion(columna[6]);
			alumno.setTelefono(columna[7]);
			alumno.setFecha_nacimiento(fecha);
			alumno.setSexo(columna[9]);
			alumnos.add(alumno);
		}
		this.iAlumnoRepository.saveAllAndFlush(alumnos);
	}
}
