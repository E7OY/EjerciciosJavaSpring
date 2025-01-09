package com.edu.eloy.EloyGarcia1Trim.entities;

import java.time.LocalDate;

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
@Table(name = "talleres_coches")

public class talleres_coches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Taller.class, optional = true)
    @JoinColumn(name = "id_taller")
    @JsonIgnore
    private Taller taller;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Coche.class, optional = true)
    @JoinColumn(name = "id_coche")
    @JsonIgnore
    private Coche coche;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fecha;

    public talleres_coches() {
    }

    public talleres_coches(Integer id, Coche coche, Taller taller, LocalDate fecha) {
        this.id = id;
        this.coche = coche;
        this.taller = taller;
        this.fecha = fecha;
    }

    public talleres_coches(Coche coche, Taller taller, LocalDate fecha) {
        this.coche = coche;
        this.taller = taller;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "talleres_coches [id=" + id + ", taller=" + taller.getNombre() + ", coche=" + coche.getMatricula() + ", fecha=" + fecha + "]";
    }
}
