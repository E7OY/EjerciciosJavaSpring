package edu.eloy.MotoGP.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eloy.MotoGP.DTOs.CarreraDTO;
import edu.eloy.MotoGP.controllers.carreraController;
import edu.eloy.MotoGP.entities.Carrera;
import edu.eloy.MotoGP.repositories.iCarrerasRepository;

@Service

public class CarrerasService implements iCarrerasService{

    @Autowired
    iCarrerasRepository carrerasRepo;

    @Override
    public List<CarreraDTO> getAllCarrerasDtos() {
        List<Carrera> carreras = carrerasRepo.findAll();
        List<CarreraDTO> carrerasDtos = new ArrayList<>();
        for (Carrera carr : carreras) {
            CarreraDTO carrdto = new CarreraDTO();
            carrdto.setCircuito(carr.getCircuito());
            carrdto.setPiloto(carr.getPiloto());
            carrdto.setPosicion(carr.getPosicion());
            carrdto.setTemporada(carr.getTemporada());
            carrerasDtos.add(carrdto);
        } 
        return carrerasDtos;
    }

    @Override
    public CarreraDTO getCarreraDTO(Integer idUrl) {
        Optional<Carrera> op = carrerasRepo.findById(idUrl);
        if (op.isPresent()) {
            Carrera carr = op.get();
            CarreraDTO carreraDTO = new CarreraDTO();
            carreraDTO.setCircuito(carr.getCircuito());
            carreraDTO.setPiloto(carr.getPiloto());
            carreraDTO.setPosicion(carr.getPosicion());
            carreraDTO.setTemporada(carr.getTemporada());
            return carreraDTO;
        }
        return null;
    }

    @Override
    public Carrera saveCarrera(Carrera carrera) {
        return carrerasRepo.save(carrera);
    }

    @Override
    public void deleteCarrera(Integer idInteger) {
        carrerasRepo.deleteById(idInteger);
    }

    @Override
    public Carrera updateCarrera(Carrera carrera) {
        return carrerasRepo.save(carrera);
    }

}
