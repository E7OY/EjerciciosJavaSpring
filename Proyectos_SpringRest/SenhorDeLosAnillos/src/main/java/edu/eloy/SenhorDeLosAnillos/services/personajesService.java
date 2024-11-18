package edu.eloy.SenhorDeLosAnillos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eloy.SenhorDeLosAnillos.entities.Personaje;
import edu.eloy.SenhorDeLosAnillos.repositories.iPersonajeRepository;

@Service

public class personajesService implements iPersonajesService {

    @Autowired
    iPersonajeRepository personajesRepo;
    
    @Override
    public List<Personaje> buscarPersonajes() {
        return personajesRepo.findAll();
    }

    @Override
    public Personaje buscarPersonajePorId(Integer id) {
        Optional<Personaje> op = personajesRepo.findById((long)id);
        if (op.isPresent()) {
            return op.get();
        } 
        return null;
    }

    @Override
    public void borrarPersonaje(Integer id) {
        personajesRepo.deleteById((long)id);
        System.out.println("Personaje eliminado.");
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajesRepo.save(personaje);
    }

    @Override
    public Personaje actualizarPersonaje(Personaje personaje) {
        return personajesRepo.save(personaje);
    }

}
