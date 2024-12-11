package com.edu.alumnosAsignaturasB.entities;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_matricula;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    @JsonIgnore    
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    @JsonIgnore
    private Asignatura asignatura;

    @Column(scale = 2, nullable = false)
    private BigDecimal nota;

    @Column(length = 4, nullable = false)
    private Integer curso;

    public Matricula(){
    }

    public Matricula(Integer id_matricula, Alumno alumno, Asignatura asignatura, BigDecimal nota, Integer curso) {
        this.id_matricula = id_matricula;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
        this.curso = curso;
    }

    public Integer getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(Integer id_matricula) {
        this.id_matricula = id_matricula;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Matricula [id_matricula=" + id_matricula + ", alumno=" + alumno + ", asignatura=" + asignatura
                + ", nota=" + nota + ", curso=" + curso + "]";
    }
}
