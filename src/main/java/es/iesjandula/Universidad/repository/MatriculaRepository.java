package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Matricula;
import es.iesjandula.Universidad.models.MatriculaId;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaId>
{

}
