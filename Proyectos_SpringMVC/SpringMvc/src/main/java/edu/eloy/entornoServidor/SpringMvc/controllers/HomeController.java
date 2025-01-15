package edu.eloy.entornoServidor.SpringMvc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import edu.eloy.entornoServidor.SpringMvc.model.Vacante;


@Controller

public class HomeController {

    @GetMapping("/")
    public String mostrarHome(Model model) {
        /* 
        model.addAttribute("mensaje", "Mensaje dinamico");  //para desplegar una variable usamos el objeto Model y el metodo addAtribute
        model.addAttribute("fecha", new Date());
        */

        String nombreJ = "Profesor de matematicas";
        Date fechaPubJ = new Date();
        double salarioJ = 9000.0;
        boolean vigenteJ = true;

        model.addAttribute("nombreHTML", nombreJ);  //para enviar las variables a la página HTML usamos el objeto model y el metodo addAtribute
        model.addAttribute("fechaHTML", fechaPubJ);
        model.addAttribute("salarioHTML", salarioJ);
        model.addAttribute("vigenteHTML", vigenteJ);
        
        return "home";  //devolvemos un string que sera el nombre de la pagina de la que mostrara la vista
    }

    @GetMapping("/listado") //para renderizar un listado
    public String mostrarListado(Model model) {
        
        List<String> lista = new LinkedList<>();

        lista.add("Ingeniero de sistemas");
        lista.add("Técnico en desarrollo");
        lista.add("Arquitecto de software");

        model.addAttribute("empleos", lista);

        return "listado";
    }
    
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de sistemas");
        vacante.setDescripcion("Se solicita para dar apoyo en la red interna");
        vacante.setFecha(new Date());
        vacante.setSalario(28800.00);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = getVacantes();
                model.addAttribute("vacantes", lista);
                return "tabla";
    }
        
    
    

    public List<Vacante> getVacantes(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  //Clase para formatear fechas
        List<Vacante> lista = new LinkedList<>();

        try {

            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Se solicita ingeniero civil para diseñar puente peatonal");
            vacante1.setSalario(8500.00);
            vacante1.setFecha(sdf.parse("08-02-2021"));  //analiza la cadena de texto "08-02-2021" y la convierte en un objeto Date.
            vacante1.setDestacado(1);
            vacante1.setImagen("springboot.svg");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador público");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia laboral");
            vacante2.setSalario(12000.00);
            vacante2.setFecha(sdf.parse("09-02-2021"));
            vacante2.setDestacado(0);
            vacante2.setImagen("springboot.svg");

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Eléctrico");
            vacante3.setDescripcion("Empresa solicita ingeniero electrico para mantenimiento del sistema eléctrico");
            vacante3.setSalario(10500.00);
            vacante3.setFecha(sdf.parse("10-02-2021"));
            vacante3.setDestacado(1);

            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico");
            vacante4.setDescripcion("Solicitamos diseñador gráfico titulado para diseñar publicidad");
            vacante4.setSalario(15000.00);
            vacante4.setFecha(sdf.parse("11-02-2021"));
            vacante4.setDestacado(0);
            vacante4.setImagen("springboot.svg");


            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch(ParseException e) {
            System.out.println("Eror: " + e.getMessage());
        }

        return lista;
    }
    

}
