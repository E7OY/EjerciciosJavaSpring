package edu.eloy.entornoServidor.SpringMvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.eloy.entornoServidor.SpringMvc.model.Categoria;
import edu.eloy.entornoServidor.SpringMvc.services.iCategoriasService;


@Controller

@RequestMapping("/categorias")

public class CategoriasController {

    @Autowired
    private iCategoriasService serviceCategorias;

    //@GetMapping("/index")
    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String mostrarIndex(Model model) {
        List<Categoria> lista = serviceCategorias.buscarTodas();
        model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }
    
    //@GetMapping("/create")
    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public String crear(Categoria categoria) {
        return "categorias/formCategoria";
    }

    //@PostMapping("/save")
    //Este método recibirá los parámetros del formulario, los valores de los requestParam deben coincidir con los nombres de los inputs del formulario
    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            System.out.println("Existieron errores");
            return "categorias/formCategorias";
        }
        //Guardamos el objeto categoria en la bd
        serviceCategorias.guardar(categoria);
        attributes.addFlashAttribute("msg", "Los datos de la categoria fueron guardados!");
        return "redirect:/categorias/index";
    }
        
}