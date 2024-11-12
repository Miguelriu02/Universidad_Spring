package es.iesjandula.Universidad.services;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoDepartamento
{
	public void parseoDepartamentoCsv(Scanner scanner) throws UniversidadServerError;
}
