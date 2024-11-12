package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long>
{

}
