package edu.eloy.MotoGP.services;

import java.util.List;

import edu.eloy.MotoGP.entities.Piloto;

public interface iPilotosService {

    public List<Piloto> getPilotos();

    public Piloto getPilotoId(Integer idUrl);

    public void borrarPiloto(Integer idUrl);

    public Piloto savePiloto(Piloto piloto);

    public Piloto updatePiloto(Piloto piloto);

}
