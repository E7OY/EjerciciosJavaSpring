package edu.rico.valorant.entities;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import edu.rico.valorant.entities.enumerated.Rol;
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
@Table(name="agentes")
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idAgente;
    @Column(length = 55, unique = true, nullable = false)
    private String nombre;
    @Enumerated(EnumType.STRING)
    @Column(name="rol", columnDefinition = "ENUM('CENTINELA', 'INICIADOR', 'DUELISTA', 'CONTROLADOR')")
    private Rol rol;
    @Column(length = 55, unique = true, nullable = false)
    private String ultimate;
    @Column(length = 55, nullable = true)
    private String pais;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "poseedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Habilidad> habilidades;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "agente", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Partida> partidas;

    
    public Long getIdAgente() {
        return idAgente;
    }
    public void setIdAgente(Long idAgente) {
        this.idAgente = idAgente;
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
        return "Agente [idAgente=" + idAgente + ", nombre=" + nombre + ", rol=" + rol + ", ultimate=" + ultimate
                + ", pais=" + pais + ", habilidades=" + habilidades + "]";
    }
    public List<Partida> getPartidas() {
        return partidas;
    }
    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
    

    
    

}
