package com.edu.eloy.EloyGarcia1Trim.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eloy.EloyGarcia1Trim.Services.TallerService;
import com.edu.eloy.EloyGarcia1Trim.entities.Taller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/talleres")

public class TalleresController {

    @Autowired
    TallerService tallerService;

    @GetMapping("/{nombre}")
    public List<Taller> getTalleres(@PathVariable String nombre) {
        return tallerService.getTalleres(nombre);
    }
    

}
