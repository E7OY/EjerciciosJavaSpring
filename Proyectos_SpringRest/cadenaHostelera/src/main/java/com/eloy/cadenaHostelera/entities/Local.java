package com.eloy.cadenaHostelera.entities;

import java.math.BigDecimal;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "locales")

public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_local;

    @Column(length = 55, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer aforo_maximo;

    @Column(precision = 4, scale = 2, nullable = false)
    private BigDecimal metros_cuadrados;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Miembro> listaEmpleados;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "clientes_locales",
        joinColumns = @JoinColumn(name = "Local_id"),
        inverseJoinColumns = @JoinColumn(name = "Cliente_id")
    )


    private List<Cliente> clientes;
    public Local() {
    }

    public Local(Integer id_local, String nombre, Integer aforo_maximo, BigDecimal metros_cuadrados) {
        this.id_local = id_local;
        this.nombre = nombre;
        this.aforo_maximo = aforo_maximo;
        this.metros_cuadrados = metros_cuadrados;
    }

    public Local(String nombre, Integer aforo_maximo, BigDecimal metros_cuadrados) {
        this.nombre = nombre;
        this.aforo_maximo = aforo_maximo;
        this.metros_cuadrados = metros_cuadrados;
    }

    public Integer getId_local() {
        return id_local;
    }

    public void setId_local(Integer id_local) {
        this.id_local = id_local;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAforo_maximo() {
        return aforo_maximo;
    }

    public void setAforo_maximo(Integer aforo_maximo) {
        this.aforo_maximo = aforo_maximo;
    }

    public BigDecimal getMetros_cuadrados() {
        return metros_cuadrados;
    }

    public void setMetros_cuadrados(BigDecimal metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


    @Override
    public String toString() {
        return "Local [id_local=" + id_local + ", nombre=" + nombre + ", aforo_maximo=" + aforo_maximo
                + ", metros_cuadrados=" + metros_cuadrados + "]";
    }

}
