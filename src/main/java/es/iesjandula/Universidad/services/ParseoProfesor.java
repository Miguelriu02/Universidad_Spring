package es.iesjandula.Universidad.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Departamento;
import es.iesjandula.Universidad.models.Profesor;
import es.iesjandula.Universidad.repository.DepartamentoRepository;
import es.iesjandula.Universidad.repository.ProfesorRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoProfesor;
import es.iesjandula.Universidad.utils.UniversidadServerError;

@Service
public class ParseoProfesor implements IParseoProfesor
{
	@Autowired
	ProfesorRepository iProfesorRepository;
	
	@Autowired
	DepartamentoRepository iDepartamentoRepository;

	@Override
	public void parseoProfesorCsv(Scanner scanner) throws UniversidadServerError
	{

		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Profesor> profesores = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columna = line.split(",");

			Profesor profesor = new Profesor();
			
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fecha = LocalDate.parse(columna[8], formatter);
			
			profesor.setId(Long.parseLong(columna[0]));
			profesor.setNif(columna[1]);
			profesor.setNombre(columna[2]);
			profesor.setApellido1(columna[3]);
			profesor.setApellido2(columna[4]);
			profesor.setCiudad(columna[5]);
			profesor.setDireccion(columna[6]);
			profesor.setTelefono(columna[7]);
			profesor.setFecha_nacimiento(fecha);
			profesor.setSexo(columna[9]);
			
			Long departamentoId = Long.parseLong(columna[10]);
		    Departamento departamento = iDepartamentoRepository.findById(departamentoId).orElseThrow(() -> new UniversidadServerError(3, "Departamento no encontrado con ID: " + departamentoId));
			profesor.setIdDepartamento(departamento);
			
			profesores.add(profesor);
		}
		this.iProfesorRepository.saveAllAndFlush(profesores);
	}
}
