package edu.eloy.MotoGP.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import edu.eloy.MotoGP.entities.enumerated.Conduccion;
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
@Table(name = "pilotos")

public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_piloto;

    @Column(length = 55, nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PASIVA', 'AGRESIVA', 'TEMERARIA')", nullable = false)
    private Conduccion conduccion;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "piloto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Carrera> carreras;

    public Piloto(){
    }
    
    public Piloto(Integer id_piloto, String nombre, Conduccion conduccion) {
        this.id_piloto = id_piloto;
        this.nombre = nombre;
        this.conduccion = conduccion;
    }

    public Piloto(String nombre, Conduccion conduccion) {
        this.nombre = nombre;
        this.conduccion = conduccion;
    }

    public Integer getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(Integer id_piloto) {
        this.id_piloto = id_piloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Conduccion getConduccion() {
        return conduccion;
    }

    public void setConduccion(Conduccion conduccion) {
        this.conduccion = conduccion;
    }

    @Override
    public String toString() {
        return "Piloto [id_piloto=" + id_piloto + ", nombre=" + nombre + ", conduccion=" + conduccion + "]";
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

}
