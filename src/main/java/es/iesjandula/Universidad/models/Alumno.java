package es.iesjandula.Universidad.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno
{
    @Id
    @Column(length= 100)  
    private Long id;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "apellido1", length = 45)
    private String apellido1;
    
    @Column(name = "apellido2", length = 45)
    private String apellido2;
    
    @Column(name = "ciudad", length = 45)
    private String ciudad;
    
    @Column(name = "direccion", length = 100)
    private String direccion;
    
    @Column(name = "nif", length = 10)
    private String nif;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name= "sexo", length = 45)
    private String sexo;
    
    @Column(name = "telefono", length = 45)
    private String telefono;
}
