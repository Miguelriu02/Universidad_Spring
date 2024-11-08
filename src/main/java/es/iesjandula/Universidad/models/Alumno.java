package es.iesjandula.Universidad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alumno extends Persona
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
