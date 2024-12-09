package com.edu.alumnosAsignaturasB.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_asignatura;


    private Alumno alumno;

    private Asignatura asignatura;

    @Column(scale = 2, nullable = false)
    private BigDecimal nota;

    @Column(length = 4, nullable = false)
    private Integer curso;

}
