package com.edu.alumnosAsignaturasB.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "alumnos")

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno;

    @Column(length = 55, nullable = false)
    private String nombre;

    @Column(length = 3, nullable = false)
    private Integer edad;

    @Column(length = 10, nullable = false)
    private String dni;

    //@OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "alumno", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Matricula> matriculas;

    public Alumno() {
    }

    public Alumno(Integer id_alumno, String nombre, Integer edad, String dni) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno [id_alumno=" + id_alumno + ", nombre=" + nombre + ", edad=" + edad + ", dni=" + dni
                + ", matriculas=" + matriculas + "]";
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
