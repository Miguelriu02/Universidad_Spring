package es.iesjandula.Universidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "es.iesjandula")
public class UniversidadApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}

}
