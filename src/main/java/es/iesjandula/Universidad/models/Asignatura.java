package es.iesjandula.Universidad.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer creditos;
	
	@Column(nullable = false)
	private Integer cuatrimestre;
	
	@Column(nullable = false)
	private Integer curso;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "id_profesor", referencedColumnName = "id", nullable = false)
	private Profesor profesor;
	
	@ManyToOne
	@JoinColumn(name = "id_grado", referencedColumnName = "id", nullable = false)
	private Grado grado;
	
}
