package edu.eloy.valorantworld.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores_agentes")

public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "agente_id")
    private Agente agente;
    
    private LocalDateTime fecha;

    public Partida() {
    }

    public Partida(Long id, Jugador jugador, Agente agente, LocalDateTime fecha) {
        this.id = id;
        this.jugador = jugador;
        this.agente = agente;
        this.fecha = fecha;
    }
    
    public Partida(Jugador jugador, Agente agente, LocalDateTime fecha) {
        this.jugador = jugador;
        this.agente = agente;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partida [id=" + id + ", jugador=" + jugador + ", agente=" + agente + ", fecha=" + fecha + "]";
    }

    
    
}
