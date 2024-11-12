package es.iesjandula.Universidad.services.interfaces;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoMatricula
{
	public void parseoMatriculaCsv(Scanner scanner) throws UniversidadServerError;
}
