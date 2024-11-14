package edu.rico.valorant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habilidades")
public class Habilidad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length=55, nullable=false)
    private String nombre;
    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;
    @ManyToOne(targetEntity = Agente.class, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="poseedor", referencedColumnName = "id")
    @JsonIgnore
    private Agente poseedor;

    public Habilidad(){}

    public Habilidad(Long id, String nombre, String descripcion, Agente poseedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poseedor = poseedor;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Agente getPoseedor() {
        return poseedor;
    }

    public void setPoseedor(Agente poseedor) {
        this.poseedor = poseedor;
    }

    @Override
    public String toString() {
        return "Habilidad [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }

        
    

}
