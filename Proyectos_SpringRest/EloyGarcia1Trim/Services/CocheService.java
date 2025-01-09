package com.edu.eloy.EloyGarcia1Trim.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.eloy.EloyGarcia1Trim.entities.Coche;
import com.edu.eloy.EloyGarcia1Trim.entities.talleres_coches;
import com.edu.eloy.EloyGarcia1Trim.entities.enumerated.TipoCoche;
import com.edu.eloy.EloyGarcia1Trim.repositories.iCocheRepository;
import com.edu.eloy.EloyGarcia1Trim.repositories.iTalleresCochesRepository;

@Service

public class CocheService implements iCochesService {

    @Autowired
    iCocheRepository cochesRepo;

    @Autowired
    iTalleresCochesRepository talleresCochesRepository;

    @Override
    public List<Coche> getCoches() {
        return cochesRepo.findAll();
    }

    @Override
    public Coche getCocheId(Integer idUrl) {
        Optional<Coche> op = cochesRepo.findById(idUrl);
        if (!op.isPresent()) {
            System.out.println("El coche con el id especificado no existe!");
            return null;
        }
        return op.get();
    }

    @Override
    public Coche saveCoche(Coche coche) {
        return cochesRepo.save(coche);
    }

    @Override
    public void deleteCoche(Integer idUrl) {
        cochesRepo.deleteById(idUrl);
    }

    @Override
    public Coche updateCoche(Coche coche) {
        return cochesRepo.save(coche);
    }

    @Override
    public List<Coche> obtenerCochesFechaAntesDeAnho(int anho) {
    LocalDate fecha = LocalDate.of(anho, 1, 1);
    Coche coche = new Coche();
    List<talleres_coches> talleresCoches = talleresCochesRepository.findByFechaBefore(fecha);
    List<Coche> coches = new ArrayList<>();
    Set<Integer> cocheIds = new HashSet<>();
    for (talleres_coches tallerCoche : talleresCoches) {
        coche = tallerCoche.getCoche();
        if (!cocheIds.contains(coche.getId())) {
            coches.add(coche);
            cocheIds.add(coche.getId());
        }
    }
    return coches;
    }

    @Override
    public List<Coche> tipoCoche(TipoCoche tipo) {
        return cochesRepo.findByTipo(tipo);
    }


}
