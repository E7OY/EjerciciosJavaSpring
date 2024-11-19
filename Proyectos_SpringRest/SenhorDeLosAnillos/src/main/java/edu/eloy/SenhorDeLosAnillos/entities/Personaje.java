package edu.eloy.SenhorDeLosAnillos.entities;

import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import edu.eloy.SenhorDeLosAnillos.entities.enumerated.Alianza;
import edu.eloy.SenhorDeLosAnillos.entities.enumerated.Raza;
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
@Table(name = "personajes")

public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personaje;

    @Column(length = 55, nullable = false, unique = true)
    private String nombre;

    @Column(columnDefinition = "ENUM('HUMANO', 'MAYAS', 'HOBBIT', 'ELFO', 'ORCO')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Raza raza;

    @Column(columnDefinition = "ENUM('LA_COMUNIDAD', 'MORDOR', 'ISENMAD', 'AVENTURERO')", nullable = false)
    @Enumerated(EnumType.STRING)
    private Alianza alianza;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "personaje",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Posesion> posesiones;



    public Personaje() {
    }

    public Personaje(Long id_personaje, String nombre, Raza raza, Alianza alianza) {
        this.id_personaje = id_personaje;
        this.nombre = nombre;
        this.raza = raza;
        this.alianza = alianza;
    }

    public Personaje(String nombre, Raza raza, Alianza alianza) {
        this.nombre = nombre;
        this.raza = raza;
        this.alianza = alianza;
    }

    public Long getIdPersonaje() {
        return id_personaje;
    }

    public void setIdPersonaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Alianza getAlianza() {
        return alianza;
    }

    public void setAlianza(Alianza alianza) {
        this.alianza = alianza;
    }

    @Override
    public String toString() {
        return "Personaje [idPersonaje=" + id_personaje + ", nombre=" + nombre + ", raza=" + raza + ", alianza="
                + alianza + "]";
    }

}
