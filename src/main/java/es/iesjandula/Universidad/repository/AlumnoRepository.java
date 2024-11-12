package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>
{

}
