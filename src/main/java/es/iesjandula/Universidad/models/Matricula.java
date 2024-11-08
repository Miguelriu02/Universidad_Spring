package es.iesjandula.Universidad.models;

import es.iesjandula.Universidad.models.id.MatriculaId;
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
