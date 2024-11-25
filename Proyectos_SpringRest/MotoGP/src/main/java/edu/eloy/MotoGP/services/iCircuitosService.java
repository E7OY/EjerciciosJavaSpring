package edu.eloy.MotoGP.services;

import java.util.List;
import edu.eloy.MotoGP.entities.Circuito;

public interface iCircuitosService {

    public List<Circuito> getAllCircuitos();

    public Circuito geCircuito(Integer idUrl);

    public void deleteCiurcuito(Integer idUrl);

    public Circuito updateCircuito(Circuito circuito);

    public Circuito saveCircuito(Circuito circuito);

    public Circuito getCircuitoPorNombre(String nombre);

}
