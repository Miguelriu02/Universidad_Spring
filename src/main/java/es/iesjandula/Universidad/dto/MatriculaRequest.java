package es.iesjandula.Universidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaRequest
{
	private Long alumnoId;
	private Long cursoId;
	private Long asignaturaId;

}
