package es.iesjandula.Universidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>
{
	List<Profesor> findNifBySexo(String sexo);
}
