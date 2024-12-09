package com.edu.alumnosAsignaturas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")

public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_asignatura;

    @Column(length = 55, nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private Integer horas;

    public Asignatura() {
    }

    public Asignatura(Integer id_asignatura, String nombre, Integer horas) {
        this.id_asignatura = id_asignatura;
        this.nombre = nombre;
        this.horas = horas;
    }

    public Integer getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Integer id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Asignatura [id_asignatura=" + id_asignatura + ", nombre=" + nombre + ", horas=" + horas + "]";
    }
}
