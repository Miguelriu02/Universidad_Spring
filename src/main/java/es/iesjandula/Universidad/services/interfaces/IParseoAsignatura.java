package es.iesjandula.Universidad.services.interfaces;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoAsignatura
{
	public void parseoAsignaturaCsv(Scanner scanner) throws UniversidadServerError;
}
