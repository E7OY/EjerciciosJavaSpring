package com.edu.eloy.EloyGarcia1Trim.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.edu.eloy.EloyGarcia1Trim.entities.enumerated.TipoCoche;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")

public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 55, nullable = false)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('DEPORTIVO', 'UTILITARIO', 'SUV')")
    private TipoCoche tipo;

    @Column(length = 55, nullable = false)
    private String matricula;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "coche", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<talleres_coches> talleres_coches;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Motor.class, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "motor", referencedColumnName = "id")
    private Motor motor;

    public Coche() {
    }

    public Coche(Integer id, String modelo, TipoCoche tipo, String matricula,
            List<com.edu.eloy.EloyGarcia1Trim.entities.talleres_coches> talleres_coches, Motor motor) {
        this.id = id;
        this.modelo = modelo;
        this.tipo = tipo;
        this.matricula = matricula;
        this.talleres_coches = talleres_coches;
        this.motor = motor;
    }

    public Coche(String modelo, TipoCoche tipo, String matricula,
            List<com.edu.eloy.EloyGarcia1Trim.entities.talleres_coches> talleres_coches, Motor motor) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.matricula = matricula;
        this.talleres_coches = talleres_coches;
        this.motor = motor;
    }

    public Coche(String modelo, TipoCoche tipo, String matricula, Motor motor) {
    this.modelo = modelo;
    this.tipo = tipo;
    this.matricula = matricula;
    this.motor = motor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<talleres_coches> getTalleres_coches() {
        return talleres_coches;
    }

    public void setTalleres_coches(List<talleres_coches> talleres_coches) {
        this.talleres_coches = talleres_coches;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Coche [id=" + id + ", modelo=" + modelo + ", Tipo=" + tipo + ", matricula=" + matricula
                + ", motor=" + motor + "]";
    }
}
