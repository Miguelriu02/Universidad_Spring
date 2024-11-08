package es.iesjandula.Universidad.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosBrutoAlumnoMatriculaDTO
{
    private int id;
    private String nombre;
    private String apellidos;
    private String asignatura;
    private int cursoEtapaCurso;
    private String cursoEtapaEtapa;
}

