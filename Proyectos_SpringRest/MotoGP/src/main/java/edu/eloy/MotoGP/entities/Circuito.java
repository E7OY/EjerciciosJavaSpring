package edu.eloy.MotoGP.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "circuitos")

public class Circuito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_circuito;

    @Column(length = 55, nullable = false)
    private String nombre;

    @Column(length = 75, nullable = false)
    private String localidad;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "circuito", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Carrera> carreras;

    public Circuito() {
    }

    public Circuito(Integer id_circuito, String nombre, String localidad) {
        this.id_circuito = id_circuito;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Circuito(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Integer getId_circuito() {
        return id_circuito;
    }

    public void setId_circuito(Integer id_circuito) {
        this.id_circuito = id_circuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Circuitos [id_circuito=" + id_circuito + ", nombre=" + nombre + ", localidad=" + localidad + "]";
    }
    
}
