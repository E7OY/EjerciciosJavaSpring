package edu.eloy.MotoGP.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eloy.MotoGP.entities.Carrera;
import edu.eloy.MotoGP.repositories.iCarrerasRepository;

@Service

public class CarrerasService implements iCarrerasService{

    @Autowired
    iCarrerasRepository carrerasRepo;

    @Override
    public List<Carrera> getAllCarreras() {
        return carrerasRepo.findAll();
    }

    @Override
    public Carrera getCarrera(Integer idUrl) {
        Optional<Carrera> op = carrerasRepo.findById(idUrl);
        if (op.isPresent()) {
            return op.get();
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
