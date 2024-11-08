package es.iesjandula.Universidad.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Persona
{	
	@Column(nullable = false)
	private Date fechaNacimiento;
	
	@Column(nullable = false)
	private String apellido1;
	
	@Column
	private String apellido2;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String direccion;
	
	@Column(nullable = false)
	private String nif;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column
	private String sexo;
	
	@Column
	private String telefono;
}
