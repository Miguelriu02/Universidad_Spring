package es.iesjandula.Matricula_Horario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "es.iesjandula")
public class MatriculaHorarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculaHorarioApplication.class, args);
	}

}
