package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>
{

}
