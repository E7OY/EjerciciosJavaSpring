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
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 55, nullable = false)
    private String apellidos;

    @Column(name = "edad", nullable = false)
    private int edad;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "idAlumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Matricula> matriculas;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellidos, int edad, List<Matricula> matriculas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
                + ", matriculas=" + matriculas + "]";
    }

}
