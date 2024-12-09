package edu.eloy.MotoGP.services;

import java.util.List;

import edu.eloy.MotoGP.DTOs.PilotoDTO;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.entities.enumerated.Conduccion;

public interface iPilotosService {

    //public List<Piloto> getPilotos();

    public PilotoDTO getPilotoDTOId(Integer idUrl);

    public void borrarPiloto(Integer idUrl);

    public Piloto savePiloto(Piloto piloto);

    public Piloto updatePiloto(Piloto piloto);

    public List<PilotoDTO> getPilotosDTO();

    public List<Piloto> getPilotosconduccion(Conduccion conduccion);

}
