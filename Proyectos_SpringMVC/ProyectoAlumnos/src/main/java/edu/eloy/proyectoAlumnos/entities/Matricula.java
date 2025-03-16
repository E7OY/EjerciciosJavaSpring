package edu.eloy.proyectoAlumnos.entities;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "matriculas")

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne(targetEntity = Alumno.class, fetch = FetchType.EAGER )
    @JoinColumn(name = "idalumno", nullable = true )
    private Alumno idAlumno;

    @ManyToOne(targetEntity = Asignatura.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idasignatura", nullable = true)
    private Asignatura idAsignatura;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date curso;

    @Column(name = "nota", precision = 4, scale = 2, nullable = true )
    private BigDecimal nota;

    public Matricula() {
    }

    public Matricula(int id, Alumno idAlumno, Asignatura idAsignatura, Date curso, BigDecimal nota) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.curso = curso;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Date getCurso() {
        return curso;
    }

    public void setCurso(Date curso) {
        this.curso = curso;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Matricula [id=" + id + ", idAlumno=" + idAlumno + ", idAsignatura=" + idAsignatura + ", curso=" + curso
                + ", nota=" + nota + "]";
    }

}
