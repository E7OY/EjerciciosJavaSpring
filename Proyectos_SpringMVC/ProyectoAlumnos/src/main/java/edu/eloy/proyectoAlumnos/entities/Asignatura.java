package edu.eloy.proyectoAlumnos.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")

public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 55, nullable = false )
    private String nombre;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "idAsignatura", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Matricula> matriculas;

    public Asignatura() {
    }

    public Asignatura(int id, String nombre, List<Matricula> matriculas) {
        this.id = id;
        this.nombre = nombre;
        this.matriculas = matriculas;
    }

    public Asignatura(String nombre, List<Matricula> matriculas) {
        this.nombre = nombre;
        this.matriculas = matriculas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return "Asignatura [id=" + id + ", nombre=" + nombre +  "]";
    }

 
}
