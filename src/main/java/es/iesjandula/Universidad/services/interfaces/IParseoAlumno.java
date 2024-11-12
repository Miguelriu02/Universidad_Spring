package es.iesjandula.Universidad.services.interfaces;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoAlumno
{
	public void parseoAlumnoCsv(Scanner scanner) throws UniversidadServerError;
}
