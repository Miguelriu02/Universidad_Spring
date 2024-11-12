package es.iesjandula.Universidad.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Constants
{
	private Constants(){}
    
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	
    public static final File CSV_DEPARTAMENTO = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "departamento.csv");
    public static final File CSV_GRADO = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "grado.csv");
    public static final File CSV_CURSO= new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "curso.csv");
    public static final File CSV_ALUMNO= new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "alumno.csv");
    public static final File CSV_PROFESOR = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "profesor.csv");
    public static final File CSV_ASIGNATURA = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "asignatura.csv");
    public static final File CSV_MATRICULA = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "csv" + File.separator + "matricula.csv");
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    
    public static Scanner scannerDepartamento()
    {
        return createScanner(CSV_DEPARTAMENTO);
    }
    
    public static Scanner scannerGrado()
    {
        return createScanner(CSV_GRADO);
    }
    
    public static Scanner scannerCurso()
    {
        return createScanner(CSV_CURSO);
    }
    
    public static Scanner scannerAlumno()
    {
        return createScanner(CSV_ALUMNO);
    }
    
    public static Scanner scannerProfesor()
    {
        return createScanner(CSV_PROFESOR);
    }
    
    public static Scanner scannerAsignatura()
    {
        return createScanner(CSV_ASIGNATURA);
    }
    
    public static Scanner scannerMatricula()
    {
        return createScanner(CSV_MATRICULA);
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    private static Scanner createScanner(File file)
    {
        try
        {
            return new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Archivo no encontrado: " + file.getPath());
            return null;
        }
    }
}
