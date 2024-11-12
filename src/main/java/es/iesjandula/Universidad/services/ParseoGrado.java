package es.iesjandula.Universidad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Grado;
import es.iesjandula.Universidad.repository.GradoRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoGrado;
import es.iesjandula.Universidad.utils.UniversidadServerError;

@Service
public class ParseoGrado implements IParseoGrado
{
	@Autowired
	GradoRepository iGradoRepository;

	@Override
	public void parseoGradoCsv(Scanner scanner) throws UniversidadServerError
	{
		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Grado> grados = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columnas = line.split(",");

			Grado grado = new Grado();

			grado.setId(Long.parseLong(columnas[0]));
			grado.setNombre(columnas[1]);
			grados.add(grado);
		}
		this.iGradoRepository.saveAllAndFlush(grados);
	}
}
