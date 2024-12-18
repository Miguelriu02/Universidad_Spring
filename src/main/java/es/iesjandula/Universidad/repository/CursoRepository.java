package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>
{

}
