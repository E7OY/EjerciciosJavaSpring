package com.eloy.cadenaHostelera.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eloy.cadenaHostelera.Services.ClientesService;
import com.eloy.cadenaHostelera.entities.Cliente;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/clientes")

public class iClienteController {

    @Autowired
    ClientesService clientesService;

    // http://localhost:8080/clientes/all 
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.status(HttpStatus.FOUND).body(clientesService.getAllClientes());
    }
    
    // http://localhost:8080/clientes/1
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer idUrl) {
        if (clientesService.getClienteId(idUrl) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(clientesService.getClienteId(idUrl));
    }

    // http://localhost:8080/clientes/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClienteId(@PathVariable("id") Integer idUrl) {
        clientesService.deleteClienteId(idUrl);
        return ResponseEntity.noContent().build();
    }    

    // http://localhost:8080/clientes/save
    @PostMapping("/save")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        Cliente clienteRegistrado = clientesService.saveCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRegistrado);
    }

    // http://localhost:8080/clientes/update
    @PutMapping("/update")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
        Cliente clienteActualizado = clientesService.updateCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteActualizado);
    }

    // http://localhost:8080/clientes/vip
    @GetMapping("/vip")
    public ResponseEntity<List<Cliente>> getClientesVip() {
        return ResponseEntity.status(HttpStatus.FOUND).body(clientesService.clientesVip());
    }
}


