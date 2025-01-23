package edu.eloy.entornoServidor.SpringMvc.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.eloy.entornoServidor.SpringMvc.model.Vacante;
import edu.eloy.entornoServidor.SpringMvc.services.iVacanteService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

@RequestMapping("/vacantes")

public class VacantesController {

    @Autowired
    iVacanteService serviceVacantes;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "home";
    }

    @GetMapping("/view/{id}") // generacion de URL dinamicas o URI template
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("Se encontró el objeto: " + vacante);
        model.addAttribute("vacante", vacante);
        return "vacantes/detalle";
    }

    // RequestParam con peticones get
    // mandamos al servidor la petición con la query string id=4
    // (/vacantes/delete?id=4), spring MVC lo parsea a entero y lo guarda en la
    // variable idVacante
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {
        System.out.println("Borrando vacante con id: " + idVacante);
        model.addAttribute("idVacanteHtml", idVacante);
        return "mensaje";
    }

    @GetMapping("/create")
    public String crear() {
        return "vacantes/formVacante";
    }

    // metodo controlador para recibir las peticiones del formulario
    @PostMapping("/save")
    public String guardar(Vacante vacante, Model model, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) { // metodo para comprobar si la conversion de datos del formulario a spring tiene errores
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacantes";
        }
        //Procesar objeto de modelo
        serviceVacantes.guardar(vacante);
        attributes.addFlashAttribute("msg", "Registro guardado adecuadamente");
        return "redirect:/vacantes/index";  //para que nos devuelva otro m etodo y no otra lista
        
    }

    /*
     * En el siguiente metodo le decimos a Spring que cuando haga la conversion de
     * los datos y encuentre
     * una propiedad de tipo Date maneje la fecha con el formato indicado en
     * dateFormat
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "vacantes/listVacantes";
    }

}
