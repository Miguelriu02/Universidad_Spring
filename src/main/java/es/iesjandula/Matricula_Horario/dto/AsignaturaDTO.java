package es.iesjandula.Matricula_Horario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO
{
	private Integer curso;
	private String etapa;
	private String grupo;
	private String nombre;
	private DepartamentoDTO departamentoPropietario;
	private DepartamentoDTO departamentoReceptor;
}
