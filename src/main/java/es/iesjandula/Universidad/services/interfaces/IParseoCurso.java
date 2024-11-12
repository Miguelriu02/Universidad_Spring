package es.iesjandula.Universidad.services.interfaces;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoCurso
{
	public void parseoCursoCsv(Scanner scanner) throws UniversidadServerError;
}
