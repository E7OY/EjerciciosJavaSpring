package edu.eloy.MotoGP.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eloy.MotoGP.DTOs.PilotoDTO;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.repositories.iPilotoRepository;

@Service

public class PilotosService implements iPilotosService {

    @Autowired
    iPilotoRepository pilotosRepo;

    @Override
    public List<PilotoDTO> getPilotosDTO() {
        List<Piloto> pilotos = pilotosRepo.findAll();
        List<PilotoDTO> pilotosDTO = new ArrayList<>();
        for(Piloto pi : pilotos) {
            PilotoDTO pidto = new PilotoDTO();
            pidto.setNombre(pi.getNombre());
            pidto.setConduccion(pi.getConduccion());
            pidto.setCarreras(pi.getCarreras());
            pilotosDTO.add(pidto);
        }
        return pilotosDTO;
    }

    @Override
    public PilotoDTO getPilotoDTOId(Integer idUrl) {
        Optional<Piloto> op = pilotosRepo.findById(idUrl);
        if (op.isPresent()) {
            PilotoDTO pilotodDto = new PilotoDTO();
            return pilotodDto;
        }
        return null;
    }

    @Override
    public void borrarPiloto(Integer idUrl) {
        pilotosRepo.deleteById(idUrl);
    }

    @Override
    public Piloto savePiloto(Piloto piloto) {
        return pilotosRepo.save(piloto);
    }

    @Override
    public Piloto updatePiloto(Piloto piloto) {
        return pilotosRepo.save(piloto);
    }

}
