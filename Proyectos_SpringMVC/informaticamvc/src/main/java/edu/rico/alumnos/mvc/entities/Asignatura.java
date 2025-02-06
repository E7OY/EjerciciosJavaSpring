package edu.rico.alumnos.mvc.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")

public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;
    @Column(name = "abreviatura", length = 5, nullable = false, unique = true)
    private String abreviatura;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany()
    private Alumno alumno;

    
    public Asignatura() {
    }
    public Asignatura(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAbreviatura() {
        return abreviatura;
    }
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    @Override
    public String toString() {
        return "Asignatura [nombre=" + nombre + ", abreviatura=" + abreviatura + "]";
    }
}
