package edu.eloy.SenhorDeLosAnillos.entities;

import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import edu.eloy.SenhorDeLosAnillos.entities.enumerated.Tipo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artefactos")

public class Artefacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_artefacto;

    @Column(length = 55, nullable = false)
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition =  "ENUM('ANILLO', 'ESPADA', 'BACULO')", nullable = false)
    private Tipo tipo;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "artefacto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Posesion> posesiones;

    public Artefacto(){
    }

    public Artefacto(String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getIdArtefacto() {
        return id_artefacto;
    }

    public void setIdArtefacto(Long id_artefacto) {
        this.id_artefacto = id_artefacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Artefacto(Long id_artefacto, String nombre, Tipo tipo) {
        this.id_artefacto = id_artefacto;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public List<Posesion> getPosesiones() {
        return posesiones;
    }

    public void setPosesiones(List<Posesion> posesiones) {
        this.posesiones = posesiones;
    }

    @Override
    public String toString() {
        return "Artefacto [id_artefacto=" + id_artefacto + ", nombre=" + nombre + ", tipo=" + tipo + ", posesiones="
                + posesiones + "]";
    }
}
