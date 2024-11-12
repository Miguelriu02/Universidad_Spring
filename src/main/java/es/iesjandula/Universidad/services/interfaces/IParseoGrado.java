package es.iesjandula.Universidad.services.interfaces;

import java.util.Scanner;

import es.iesjandula.Universidad.utils.UniversidadServerError;

public interface IParseoGrado
{
	public void parseoGradoCsv(Scanner scanner) throws UniversidadServerError;
}
