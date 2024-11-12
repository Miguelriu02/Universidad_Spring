package es.iesjandula.Universidad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.Universidad.models.Departamento;
import es.iesjandula.Universidad.repository.DepartamentoRepository;
import es.iesjandula.Universidad.services.interfaces.IParseoDepartamento;
import es.iesjandula.Universidad.utils.UniversidadServerError;

@Service
public class ParseoDepartamento implements IParseoDepartamento
{

	@Autowired
	DepartamentoRepository iDepartamentoRepository;

	@Override
	public void parseoDepartamentoCsv(Scanner scanner) throws UniversidadServerError
	{

		if (scanner.hasNextLine())
		{
			scanner.nextLine();
		}

		List<Departamento> departamentos = new ArrayList<>();

		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			String[] columnas = line.split(",");

			Departamento departamento = new Departamento();

			departamento.setId(Long.parseLong(columnas[0]));
			departamento.setNombre(columnas[1]);
			departamentos.add(departamento);
		}
		this.iDepartamentoRepository.saveAllAndFlush(departamentos);
	}
}