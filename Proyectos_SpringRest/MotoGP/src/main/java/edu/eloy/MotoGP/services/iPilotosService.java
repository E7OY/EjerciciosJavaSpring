package edu.eloy.MotoGP.services;

import java.util.List;

import edu.eloy.MotoGP.DTOs.EstadisticasPilotoDTO;
import edu.eloy.MotoGP.DTOs.PilotoDTO;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.entities.enumerated.Conduccion;

public interface iPilotosService {

    public EstadisticasPilotoDTO getEstadisticasPiloto(Integer idEp);
    public List<PilotoDTO> getListaPilotos();
    public PilotoDTO getPilotoId(Integer id);
    public PilotoDTO guardarPiloto(Piloto pi);
    public PilotoDTO actualizarPiloto(Piloto pi);
    public void eliminarPilotoId(Integer id);

}
