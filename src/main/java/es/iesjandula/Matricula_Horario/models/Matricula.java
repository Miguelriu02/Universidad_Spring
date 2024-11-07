package es.iesjandula.Matricula_Horario.models;

import es.iesjandula.Matricula_Horario.models.id.MatriculaId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Matricula
{    
    @EmbeddedId
    private MatriculaId id;
}
