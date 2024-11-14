package com.edu.eloy.CadenaHostelera.entities;

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
    @Column(name = "idLocal")
    private Integer idLocal;

    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;

    @Column(name = "aforo_maximo", nullable = false, precision = 4)
    private Integer aforo;

    @Column(name = "metros_cuadrados", nullable = false, precision = 6, scale = 2 )
    private BigDecimal metros_cuadrados;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> listaEmpleados;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "clientes_locales",
        joinColumns = @JoinColumn(name = "Local_id"),
        inverseJoinColumns = @JoinColumn(name = "Cliente_id")
    )
    private List<Cliente> clientes;


    public Local() {
    }

    public Local(Integer idLocal, String nombre, Integer aforo, BigDecimal metros_cuadrados,
            List<Empleado> listaEmpleados, List<Cliente> clientes) {
        this.idLocal = idLocal;
        this.nombre = nombre;
        this.aforo = aforo;
        this.metros_cuadrados = metros_cuadrados;
        this.listaEmpleados = listaEmpleados;
        this.clientes = clientes;
    }

    public Local(String nombre, Integer aforo, BigDecimal metros_cuadrados,
            List<Empleado> listaEmpleados, List<Cliente> clientes) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.metros_cuadrados = metros_cuadrados;
        this.listaEmpleados = listaEmpleados;
        this.clientes = clientes;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMetros_cuadrados() {
        return metros_cuadrados;
    }

    public void setMetros_cuadrados(BigDecimal metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    

    @Override
    public String toString() {
        return "Local [idLocal=" + idLocal + ", nombre=" + nombre + ", aforo=" + aforo
                + ", metros_cuadrados=" + metros_cuadrados + ", listaEmpleados=" + listaEmpleados +  "]";
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }
    
    
}
