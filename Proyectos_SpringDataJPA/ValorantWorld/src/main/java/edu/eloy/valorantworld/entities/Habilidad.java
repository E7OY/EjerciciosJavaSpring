package edu.eloy.valorantworld.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habilidades")

public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    /*Anotación para indicar que la relación es de muchos a uno, muchas habilidades pertenecen a un agente
    targetEntity = Agente.class, indica la clase destino con la que está relacionada
    optional = true, indica que la relación es opcional, es decir, una habilidad puede existir sin un agente
    */
    @ManyToOne(targetEntity = Agente.class, optional = true, fetch = FetchType.EAGER)
    //En la entidad hija, se debe indicar el nombre de la columna que actuará como clave foránea y el nombre de la columna de la entidad padre con la que se relaciona
    @JoinColumn(name = "poseedor", referencedColumnName = "id")
    private Agente poseedor;

    public Habilidad() {
    }

    public Habilidad(Long id, String nombre, String descripcion, Agente poseedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poseedor = poseedor;
    }
    
    public Habilidad(String nombre, String descripcion, Agente poseedor) {
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
