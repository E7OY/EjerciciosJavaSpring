package edu.eloy.valorantworld.entities;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import edu.eloy.valorantworld.enumerated.Rol;
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

//Anotación para indicar que la clase es una entidad
@Entity
//Anotación para indicar el nombre de la tabla en la base de datos con la que mappeará la entidad
@Table(name = "agentes")


public class Agente {

    //Anotación para indicar una propiedad como clave primaria
    @Id
    //Anotación para indicar que la clave primaria es generada automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    //Anotación para indicar que el atributo es un enumerado y nos utilice los enums como strings en vez de numeros (Mapea el enum como String):
    @Enumerated(EnumType.STRING)
    //Anotación para limitar los valores válidos de rol a los que se encuentran en el enum Rol:
    @Column(name = "rol", columnDefinition = "ENUM('CENTINELA', 'INICIADOR', 'DUELISTA', 'CONTROLADOR')")
    private Rol rol;
    private String ultimate;
    private String pais;
    /*Anotación para indicar que la relación es de uno a muchos, un agente tendrá varias habilidades. 
    MappedBy = "poseedor", significa que la relación está siendo mapeada por el campo poseedor de la clase Habilidad
    cascade = CascadeType.ALL, indica que todas las operaciones que se realicen sobre un agente se propagarán a sus habilidades
    fetch = FetchType.EAGER, indica que las habilidades se cargarán en memoria cuando se cargue un agente, es decir, cuando recuperas un agente, también recuperas sus habilidades evitando la carga perezosa y eliminando la necesidad de hacer una consulta adicional para recuperar las habilidades de un agente
    */
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "poseedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Habilidad> habilidades;


    @OnDelete(action = OnDeleteAction.CASCADE)
    //Anotación para indicar que la relación es de muchos a muchos, muchos agentes pueden tener muchos jugadores, es decir, es una relacion bidireccional
    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Partida> partidas;
        
    
    
    
    public Agente() {
    }

    public Agente(Long id, String nombre, Rol rol, String ultimate, String pais, List<Habilidad> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.ultimate = ultimate;
        this.pais = pais;
        this.habilidades = habilidades;
    }

    public Agente(String nombre, Rol rol, String ultimate, String pais, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.rol = rol;
        this.ultimate = ultimate;
        this.pais = pais;
        this.habilidades = habilidades;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUltimate() {
        return ultimate;
    }

    public void setUltimate(String ultimate) {
        this.ultimate = ultimate;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Agente [id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", ultimate=" + ultimate + ", pais=" + pais
                + ", habilidades=" + habilidades + "]";
    }


    
}

