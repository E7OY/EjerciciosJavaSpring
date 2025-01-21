package edu.eloy.entornoServidor.SpringMvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.eloy.entornoServidor.SpringMvc.model.Vacante;

@Service

//Impl quiere decir que será la implementación de IVacantesService

public class VacantesServiceImpl implements iVacanteService {

    @Override
    public List<Vacante> buscarTodas() {

        return lista;
    }


    //Así podremos usar la lista en cualquier método del servicio
    public List<Vacante> lista  = null;

    
    public VacantesServiceImpl(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  //Clase para formatear fechas
        lista = new LinkedList<Vacante>();

        try {

            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Se solicita ingeniero civil para diseñar puente peatonal");
            vacante1.setSalario(8500.00);
            vacante1.setFecha(sdf.parse("08-02-2021"));  //analiza la cadena de texto "08-02-2021" y la convierte en un objeto Date.
            vacante1.setDestacado(1);
            vacante1.setImagen("logo2.png");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador público");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia laboral");
            vacante2.setSalario(12000.00);
            vacante2.setFecha(sdf.parse("09-02-2021"));
            vacante2.setDestacado(0);
            vacante2.setImagen("logo3.png");

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
            vacante4.setImagen("logo4.png");


            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch(ParseException e) {
            System.out.println("Eror: " + e.getMessage());
        }
    }


    @Override
    public Vacante buscarPorId(Integer idVacante) {
        for(Vacante vacante : lista) {
            if (vacante.getId() == idVacante) {
                return vacante;
            }
        }
        return null;
    }

}
