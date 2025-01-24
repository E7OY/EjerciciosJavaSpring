package edu.eloy.entornoServidor.SpringMvc.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eloy.entornoServidor.SpringMvc.model.Categoria;

@Service

public class CategoriasServiceImpl implements iCategoriasService {

    private List<Categoria> lista = null;

    public CategoriasServiceImpl() {
        lista = new LinkedList<Categoria>();

        // Categoria 1
        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setNombre("Contabilidad");
        cat1.setDescripcion("Descripcion de la categoria contabilidad");

        // Categoria 2
        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setNombre("Ventas");
        cat2.setDescripcion("Trabajos relacionados con ventas");

        // Categoria 3
        Categoria cat3 = new Categoria();
        cat3.setId(3);
        cat3.setNombre("Comunicaciones");
        cat3.setDescripcion("Trabajos relacionados con comunicaciones");

        // Categoria 4
        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setNombre("Arquitectura");
        cat4.setDescripcion("Trabajos de arquitectura");

        // Categoria 5
        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setNombre("Educacion");
        cat5.setDescripcion("Maestros, tutores, etc");

        // Caategoria 6
        Categoria cat6 = new Categoria();
        cat6.setId(6);
        cat6.setNombre("Desarrollo software");
        cat6.setDescripcion("Programacion");
        /*
         * Agregamos los 5 objetos de tipo categoria a la lista
         */

        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        lista.add(cat4);
        lista.add(cat5);
        lista.add(cat6);
    }

    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria cat : lista) {
            if (cat.getId() == idCategoria) {
                return cat;
            }
        }
        return null;
    }

}
