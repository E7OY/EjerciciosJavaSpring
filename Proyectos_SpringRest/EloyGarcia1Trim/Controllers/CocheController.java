package com.edu.eloy.EloyGarcia1Trim.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.eloy.EloyGarcia1Trim.Services.iCochesService;
import com.edu.eloy.EloyGarcia1Trim.entities.Coche;
import com.edu.eloy.EloyGarcia1Trim.entities.enumerated.TipoCoche;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/coches")

public class CocheController {

    @Autowired
    iCochesService cochesService;

    @GetMapping("/all")
    public List<Coche> getCoches() {
        return cochesService.getCoches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCocheId(@PathVariable("id") Integer idUrl) {
        if(cochesService.getCocheId(idUrl) == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
			return ResponseEntity.status(HttpStatus.FOUND).body(cochesService.getCocheId(idUrl));
    }

    @PostMapping("/guardar")
    @Transactional
    public Coche saveCoche(@RequestBody Coche coche) {
        return cochesService.saveCoche(coche);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteCoche(@PathVariable("id") Integer idUrl) {
        if (cochesService.getCocheId(idUrl) == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            cochesService.deleteCoche(idUrl);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }


    @PutMapping("/actualizar")
    @Transactional
    public ResponseEntity<Coche> updateCoche(@RequestBody Coche coche) {
        Integer id = coche.getId();
        if (cochesService.getCocheId(id) == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cochesService.updateCoche(coche));
        }
    }

    @GetMapping("/historial/{anhoMax}")
    public List<Coche> obtenerCochesAntesDeAnho(@PathVariable("anhoMax") int anho) {
        return cochesService.obtenerCochesFechaAntesDeAnho(anho);
    }


    @GetMapping("/tipo/{tipo}")
    public List<Coche> getTiposCoches(@PathVariable("tipo") TipoCoche tipocoche) {
        return cochesService.tipoCoche(tipocoche);
    } 
    
} 
