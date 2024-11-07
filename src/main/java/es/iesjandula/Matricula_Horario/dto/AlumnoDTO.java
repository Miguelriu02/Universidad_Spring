package es.iesjandula.Matricula_Horario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO
{
	private Integer id;
	private String nombre;
	private String apellidos;
}