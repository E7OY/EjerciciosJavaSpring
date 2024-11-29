package edu.eloy.MotoGP.services;

import java.util.List;

import edu.eloy.MotoGP.DTOs.CircuitoDTO;
import edu.eloy.MotoGP.entities.Circuito;

public interface iCircuitosService {

    public List<CircuitoDTO> getAllCircuitosDTO();

    public CircuitoDTO geCircuitoDTO(Integer idUrl);

    public void deleteCiurcuito(Integer idUrl);

    public Circuito updateCircuito(Circuito circuito);

    public Circuito saveCircuito(Circuito circuito);

    public Circuito getCircuitoPorNombre(String nombre);

}
