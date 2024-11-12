package es.iesjandula.Universidad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Curso;
import es.iesjandula.Universidad.repository.CursoRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoCurso;
import es.iesjandula.Universidad.utils.UniversidadServerError;

@Service
public class ParseoCurso implements IParseoCurso
{
	@Autowired
	CursoRepository iCursoRepository;

	@Override
	public void parseoCursoCsv(Scanner scanner) throws UniversidadServerError
	{

		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Curso> cursos = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columnas = line.split(",");

			Curso curso = new Curso();

			curso.setId(Long.parseLong(columnas[0]));
			curso.setAny_inicio(Integer.parseInt(columnas[1]));
			curso.setAny_fin(Integer.parseInt(columnas[2]));
			cursos.add(curso);
		}
		this.iCursoRepository.saveAllAndFlush(cursos);
	}
}
