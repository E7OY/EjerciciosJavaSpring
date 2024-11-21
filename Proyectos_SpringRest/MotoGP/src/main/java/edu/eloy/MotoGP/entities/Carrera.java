package edu.eloy.MotoGP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eloy.MotoGP.entities.enumerated.Posicion;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carreras")

public class Carrera {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id_carrera;

    @ManyToOne
    @JoinColumn(name = "id_piloto")
    @JsonIgnore
    private Piloto piloto;

    @ManyToOne
    @JoinColumn(name = "id_circuito")
    @JsonIgnore
    private Circuito circuito;

    @Column(length = 5, nullable = false)
    private String temporada;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PRIMERO', 'SEGUNDO', 'TERCERO', 'CUARTO', 'QUINTO', 'SEXTO', 'SÉPTIMO', 'OCTAVO', 'NOVENO', 'DÉCIMO', 'UNDÉCIMO', 'DUODÉCIMO', 'DECIMOTERCERO', 'DECIMOCUARTO', 'DECIMOQUINTO', 'DECIMOSEXTO', 'DECIMOSÉPTIMO', 'DECIMOCTAVO', 'DECIMONOVENO', 'VIGÉSIMO', 'VIGÉSIMOPRIMERO', 'VIGÉSIMOSEGUNDO', 'VIGÉSIMOTERCERO')")
    private Posicion posicion;

    public Carrera() {
    }

    public Carrera(Integer id_carrera, Piloto piloto, Circuito circuito, String temporada, Posicion posicion) {
        this.id_carrera = id_carrera;
        this.piloto = piloto;
        this.circuito = circuito;
        this.temporada = temporada;
        this.posicion = posicion;
    }

    public Carrera(Piloto piloto, Circuito circuito, String temporada, Posicion posicion) {
        this.piloto = piloto;
        this.circuito = circuito;
        this.temporada = temporada;
        this.posicion = posicion;
    }

    public Integer getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Integer id_carrera) {
        this.id_carrera = id_carrera;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Carrera [id_carrera=" + id_carrera + ", piloto=" + piloto + ", circuito=" + circuito + ", temporada="
                + temporada + ", posicion=" + posicion + "]";
    }

}
