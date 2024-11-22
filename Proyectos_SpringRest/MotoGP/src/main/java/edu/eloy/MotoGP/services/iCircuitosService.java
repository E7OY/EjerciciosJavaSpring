package edu.eloy.MotoGP.services;

import java.util.List;

import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;

import edu.eloy.MotoGP.entities.Circuito;

public interface iCircuitosService {

    public List<Circuito> getAllCircuitos();

    public Circuito geCircuito(Integer idUrl);

    public void deleteCiurcuito(Integer idUrl);

    public Circuito updateCircuito(Circuito circuito);

    public Circuito saveCircuito(Circuito circuito);

}
