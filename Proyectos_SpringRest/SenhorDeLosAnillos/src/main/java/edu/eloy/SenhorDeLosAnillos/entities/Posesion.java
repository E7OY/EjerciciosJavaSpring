package edu.eloy.SenhorDeLosAnillos.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "posesiones")

public class Posesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosesion;

    @ManyToOne
    @JoinColumn(name = "id_personaje")
    @JsonIgnore
    private Personaje personaje;

    @ManyToOne
    @JoinColumn(name = "id_artefacto")
    @JsonIgnore
    private Artefacto artefacto;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = true)
    @Temporal(TemporalType.DATE)
    private LocalDate fechaFin;

    public Posesion() {
    }

    public Posesion(Long idPosesion, Personaje personaje, Artefacto artefacto, LocalDate fechaInicio,
            LocalDate fechaFin) {
        this.idPosesion = idPosesion;
        this.personaje = personaje;
        this.artefacto = artefacto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    
    public Posesion(Personaje personaje, Artefacto artefacto, LocalDate fechaInicio,
            LocalDate fechaFin) {
        this.personaje = personaje;
        this.artefacto = artefacto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getIdPosesion() {
        return idPosesion;
    }

    public void setIdPosesion(Long idPosesion) {
        this.idPosesion = idPosesion;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Artefacto getArtefacto() {
        return artefacto;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Posesion [idPosesion=" + idPosesion + ", personaje=" + personaje.getNombre() + ", artefacto=" + artefacto.getNombre()
                + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
    }

    
    
}
