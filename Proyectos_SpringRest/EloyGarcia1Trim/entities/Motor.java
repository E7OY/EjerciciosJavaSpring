package com.edu.eloy.EloyGarcia1Trim.entities;

import com.edu.eloy.EloyGarcia1Trim.entities.enumerated.Tipo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "motores")

public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('V6', 'W6', 'V12', 'ELECTRICO', 'HIDROGENO')")
    private Tipo tipo;

    @Column(length = 55, nullable = false)
    private String fabricante;

    public Motor() {
    }

    public Motor(Integer id, Tipo tipo, String fabricante) {
        this.id = id;
        this.tipo = tipo;
        this.fabricante = fabricante;
    }

    public Motor(Tipo tipo, String fabricante) {
        this.tipo = tipo;
        this.fabricante = fabricante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Motor [id=" + id + ", tipo=" + tipo + ", fabricante=" + fabricante + "]";
    }
}
