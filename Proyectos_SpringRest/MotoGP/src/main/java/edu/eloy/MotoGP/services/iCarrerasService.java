package edu.eloy.MotoGP.services;

import java.util.List;

import edu.eloy.MotoGP.DTOs.CarreraDTO;
import edu.eloy.MotoGP.entities.Carrera;

public interface iCarrerasService {

    public List<CarreraDTO> getAllCarrerasDtos();

    public CarreraDTO getCarreraDTO(Integer idUrl);

    public Carrera saveCarrera(Carrera carrera);

    public void deleteCarrera(Integer idInteger);

    public Carrera updateCarrera(Carrera carrera);


}
