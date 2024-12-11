package edu.eloy.MotoGP.DTOs;

public class EstadisticasPilotoDTO {

private String nombrePiloto;
private Integer numeroCarreras;


public EstadisticasPilotoDTO() {}


public String getNombrePiloto() {
    return nombrePiloto;
}


public void setNombrePiloto(String nombrePiloto) {
    this.nombrePiloto = nombrePiloto;
}


public Integer getNumeroCarreras() {
    return numeroCarreras;
}


public void setNumeroCarreras(Integer numeroCarreras) {
    this.numeroCarreras = numeroCarreras;
}


@Override
public String toString() {
    return "EstadisticasPilotoDTO [nombrePiloto=" + nombrePiloto + ", numeroCarreras=" + numeroCarreras + "]";
}



}