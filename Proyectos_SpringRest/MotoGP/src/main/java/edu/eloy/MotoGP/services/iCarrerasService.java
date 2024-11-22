package edu.eloy.MotoGP.services;

import java.util.List;

import edu.eloy.MotoGP.entities.Carrera;

public interface iCarrerasService {

    public List<Carrera> getAllCarreras();

    public Carrera getCarrera(Integer idUrl);

}
