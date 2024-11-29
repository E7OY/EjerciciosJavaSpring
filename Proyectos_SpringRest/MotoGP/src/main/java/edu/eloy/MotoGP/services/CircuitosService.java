package edu.eloy.MotoGP.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eloy.MotoGP.DTOs.CircuitoDTO;
import edu.eloy.MotoGP.entities.Circuito;
import edu.eloy.MotoGP.repositories.iCircuitosRepository;

@Service

public class CircuitosService implements iCircuitosService {

    @Autowired
    iCircuitosRepository circuitosRepo;

    @Override
    public List<CircuitoDTO> getAllCircuitosDTO() {
        List<Circuito> circuitos = circuitosRepo.findAll();
        List<CircuitoDTO> circuitoDTOs = new ArrayList<>();
        for(Circuito cir : circuitos) {
            CircuitoDTO cirdto = new CircuitoDTO();
            cirdto.setNombre(cir.getNombre());
            cirdto.setLocalidad(cir.getLocalidad());
            cirdto.setCarreras(cir.getCarreras());
        }
        return circuitoDTOs;
    }

    @Override
    public CircuitoDTO geCircuitoDTO(Integer idUrl) {
        Optional<Circuito> op = circuitosRepo.findById(idUrl);
        if (op.isPresent()) {
            CircuitoDTO circuDto = new CircuitoDTO();
            return circuDto;
        }
        return null;
    }

    @Override
    public void deleteCiurcuito(Integer idUrl) {
        circuitosRepo.deleteById(idUrl);
    }

    @Override
    public Circuito updateCircuito(Circuito circuito) {
        return circuitosRepo.save(circuito);
    }

    @Override
    public Circuito saveCircuito(Circuito circuito) {
        return circuitosRepo.save(circuito);
    }

    @Override
    public Circuito getCircuitoPorNombre(String nombre) {
        return circuitosRepo.findByNombre(nombre);
    }

    

}
