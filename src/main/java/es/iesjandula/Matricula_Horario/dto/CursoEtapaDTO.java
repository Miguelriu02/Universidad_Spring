package es.iesjandula.Matricula_Horario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoEtapaDTO
{
    private int curso;
    private String etapa;
}