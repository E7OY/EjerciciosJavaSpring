package edu.eloy.entornoServidor.SpringMvc.model;

import java.util.Date;

public class Vacante {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double salario;
    private Integer destacado;
    private String imagen="no-image.png";
    private String estatus;
    private String detalles;
    private Categoria categoria;
    
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getDestacado() {
        return destacado;
    }
    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }
    
    
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    @Override
    public String toString() {
        return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
                + ", salario=" + salario + ", destacado=" + destacado + ", imagen=" + imagen + ", estatus=" + estatus
                + ", detalles=" + detalles + ", categoria=" + categoria + "]";
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
