package edu.eloy.entornoServidor.SpringMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

@RequestMapping("/categorias")

public class CategoriasController {

    //@GetMapping("/index")
    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {
        return "categorias/listCategorias";
    }
    
    //@GetMapping("/create")
    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public String crear() {
        return "categorias/formCategorias";
    }

    //@PostMapping("/save")
    //Este método recibirá los parámetros del formulario, los valores de los requestParam deben coincidir con los nombres de los inputs del formulario
    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
        System.out.println("Categoria: " + nombre + " creada. Su descripción es: " + descripcion);
        return "categorias/listCategorias";
    }
        
}