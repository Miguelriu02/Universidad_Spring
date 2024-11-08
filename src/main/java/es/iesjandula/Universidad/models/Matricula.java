package es.iesjandula.Universidad.models;

import es.iesjandula.Universidad.models.id.MatriculaId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Matricula
{    
    @EmbeddedId
    private MatriculaId id;
}
