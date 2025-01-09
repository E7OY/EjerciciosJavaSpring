package com.edu.eloy.EloyGarcia1Trim.entities;

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
@Table(name = "talleres")

public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 55, nullable = false)
    private String nombre;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "taller", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<talleres_coches> talleres_coches;

    public Taller() {
    }

    public Taller(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Taller(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public String toString() {
        return "Taller [id=" + id + ", nombre=" + nombre + ", talleres_coches=" + talleres_coches + "]";
    }

    public List<talleres_coches> getTalleres_coches() {
        return talleres_coches;
    }

    public void setTalleres_coches(List<talleres_coches> talleres_coches) {
        this.talleres_coches = talleres_coches;
    }

    
}
