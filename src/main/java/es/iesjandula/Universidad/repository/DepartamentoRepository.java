package es.iesjandula.Universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.Universidad.models.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>
{

}
