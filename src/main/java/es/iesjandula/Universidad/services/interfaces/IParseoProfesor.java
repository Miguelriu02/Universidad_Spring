package es.iesjandula.Universidad.services.interfaces;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoProfesor
{
	public void parseoProfesorCsv(Scanner scanner) throws UniversidadServerError;
}
