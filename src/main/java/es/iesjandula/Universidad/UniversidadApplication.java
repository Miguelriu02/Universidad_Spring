package es.iesjandula.Universidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.Universidad.services.interfaces.IParseoAlumno;
import es.iesjandula.Universidad.services.interfaces.IParseoAsignatura;
import es.iesjandula.Universidad.services.interfaces.IParseoCurso;
import es.iesjandula.Universidad.services.interfaces.IParseoDepartamento;
import es.iesjandula.Universidad.services.interfaces.IParseoGrado;
import es.iesjandula.Universidad.services.interfaces.IParseoMatricula;
import es.iesjandula.Universidad.services.interfaces.IParseoProfesor;
import es.iesjandula.Universidad.utils.Constants;

@SpringBootApplication
@ComponentScan(basePackages = "es.iesjandula")
public class UniversidadApplication implements CommandLineRunner
{

	@Autowired
	private IParseoAlumno iParseoAlumno;
	
	@Autowired
	private IParseoCurso iParseoCurso;
	
	@Autowired
	private IParseoDepartamento iParseoDepartamento;
	
	@Autowired
	private IParseoGrado iParseoGrado;

	@Autowired
	private IParseoProfesor iParseoProfesor;
	
	@Autowired
	private IParseoAsignatura iParseoAsignatura;
	
	@Autowired
	private IParseoMatricula iParseoMatricula;
	
	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception
	{
		this.iParseoAlumno.parseoAlumnoCsv(Constants.scannerAlumno());
		this.iParseoCurso.parseoCursoCsv(Constants.scannerCurso());
		this.iParseoDepartamento.parseoDepartamentoCsv(Constants.scannerDepartamento());
		this.iParseoGrado.parseoGradoCsv(Constants.scannerGrado());
		this.iParseoProfesor.parseoProfesorCsv(Constants.scannerProfesor());
		this.iParseoAsignatura.parseoAsignaturaCsv(Constants.scannerAsignatura());
		this.iParseoMatricula.parseoMatriculaCsv(Constants.scannerMatricula());
	}

}
