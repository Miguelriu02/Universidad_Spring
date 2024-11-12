package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>
{

}
