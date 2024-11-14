package com.edu.eloy.CadenaHostelera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import com.edu.eloy.CadenaHostelera.entities.Cliente;
import com.edu.eloy.CadenaHostelera.entities.Empleado;
import com.edu.eloy.CadenaHostelera.entities.Local;
import com.edu.eloy.CadenaHostelera.entities.enumerated.Categoria;
import com.edu.eloy.CadenaHostelera.repositories.iClientesRepo;
import com.edu.eloy.CadenaHostelera.repositories.iEmpleadosRepo;
import com.edu.eloy.CadenaHostelera.repositories.iLocalesRepo;

@SpringBootApplication
public class CadenaHosteleraApplication implements CommandLineRunner {

	@Autowired
	iClientesRepo clientesRepo;

	@Autowired
	iLocalesRepo localesRepo;

	@Autowired
	iEmpleadosRepo empleadosRepo;

	public static void main(String[] args) {
		SpringApplication.run(CadenaHosteleraApplication.class, args);
	}


	//2. CREA UN METODO PARA VER QUE CLIENTES SON VIP Y TIENEN MAS DE 20 AÑOS
	private static List<Cliente> detectarEdadCliente(List<Cliente> listaClientes, int edadLimite) {
		//Metodo static porque no es necesario instanciar un objeto par ausarlo, solo necesitamos la lista de cliente
		int anhoActual = LocalDate.now().getYear();
		List<Cliente> clientesEdadOk = new ArrayList<>();  //La lista la creamos aqui porque dentro del for no nos deja retornarla
		for (Cliente cliente : listaClientes) {  //Para cada objeto cliente de la lista clientes
			int edad = cliente.getFecha_nacimiento().getYear();
			if (edad <= anhoActual - edadLimite) {
				clientesEdadOk.add(cliente);	
			}
		}
		return clientesEdadOk;
	}


	//5. CREA UN MÉTODO PARA VER QUÉ TRABAJADORES TIENE UN LOCAL, INTRODUCIENDO EL NOMBRE DEL LOCAL
	private void verTrabajadoresPorNombreLocal(String nombre) {
		Local localBuscado = localesRepo.findByNombre(nombre);

		if (localBuscado == null) {
			System.out.println("No hay locales con ese nombre");
		} else {
			int i = 0;
			for (Empleado empleado : localBuscado.getListaEmpleados()) {
				i++;
				System.out.println("EMPLEADO Nº" + i + " => " + empleado.getNombre() + " " + empleado.getApellido1());
			}
		}
	}


	//6. MUESTRA TODA LA INFORMACIÓN DE UN TRABAJADOR HACIENDO QUE SE VEA EN QUÉ LOCAL TRABAJA.
	private void infoTrabajadorPorId(Integer id) {
		Optional<Empleado> op = empleadosRepo.findById(id);
		if (op.isPresent()) {
			System.out.println(op.get());
		} else {
			System.out.println("No existe un empleado con el id especificado.");
		}
	}


	//7. GUARDA UN NUEVO CLIENTE EN LA TABLA CLIENTES
	private void insertarClienteBD(Cliente cliente) {
		Cliente clienteEnBD = clientesRepo.save(cliente);
		if (clienteEnBD.getIdCliente()!= null) {
			System.out.println("CLIENTE INSERTADO CORRECTAMENTE.");
		} else {
			System.out.println("ERROR AL INSERTAR EL CLIENTE.");
		}
	}


	//8. ACTUALIZA LA INFORMACION DE ESE CLIENTE
	private void actualizarInfoCliente(Cliente cliente){
		Optional<Cliente> opBd = clientesRepo.findById(cliente.getIdCliente());
		if (opBd.isPresent()) {
			Cliente clienteBd = opBd.get();
			System.out.println("Se proce a actualizar el cliente: " + clienteBd);
			clientesRepo.save(cliente);
			System.out.println("Cliente actualizado: " + cliente);
		} else {
			System.out.println("El cliente con el id " + cliente.getIdCliente() + " no existe.");
		}
	}


	//9. BUSQUE ESE CLIENTE SEGUN SU ID
	private void buscarClientePorId(Integer id) {
		Optional<Cliente> op = clientesRepo.findById(id);
		if (op.isPresent()) {
			System.out.println(op.get());
		} else {
			System.out.println("El cliente con el id: " + id + " no existe.");
		}
	}

	//10. ELIMINA DICHO CLIENTE
	private void eliminarCliente(Integer id) {
		Optional<Cliente> op = clientesRepo.findById(id);
		if (op.isPresent()) {
			clientesRepo.deleteById(id);
			System.out.println("Cliente eliminado correctamente.");
		} else {
			System.out.println("El cliente con el id: " + id + " no se ha podido eliminar porque no existe.");
		}
	}

	

	@Override
	public void run(String... args) throws Exception {
		
		//1. CREA UN MÉTODO PARA VER QUE CLIENTES SON VIP
//		System.out.println(clientesRepo.findByCategoria(Categoria.VIP));

		//2. CREA UN METODO PARA VER QUE CLIENTES SON VIP Y TIENEN MAS DE 20 AÑOS
//		System.out.println(detectarEdadCliente(clientesRepo.findByCategoria(Categoria.VIP), 20));

		//3. CREA UN MÉTODO QUE BUSQUE QUE LOCALES PUEDEN ACOGER ENTRE 50 Y 100 PERSONAS
		System.out.println(localesRepo.findByAforoBetween(50, 100));

		//4. CREA UN MÉTODO PARA ENCONTRAR UN CLIENTE SEGÚN SU ID Y PODER VER EN QUÉ LOCALES SALE DE FIESTA
//		System.out.println(clientesRepo.findByIdClienteAndLocales(1, localesRepo.findAll().get(0)));   //el .get(0) es para coger el primer local de la lista de locales

		 //5. CREA UN MÉTODO PARA VER QUÉ TRABAJADORES TIENE UN LOCAL, INTRODUCIENDO EL NOMBRE DEL LOCAL
//		verTrabajadoresPorNombreLocal("LOCAL B");

		//6. MUESTRA TODA LA INFORMACIÓN DE UN TRABAJADOR HACIENDO QUE SE VEA EN QUÉ LOCAL TRABAJA.
//		infoTrabajadorPorId(4);

		//7. GUARDA UN NUEVO CLIENTE EN LA TABLA CLIENTES
//		Cliente clienteInsertar = new Cliente("vini", "jr", "martinez", LocalDate.of(2000, 12, 13), 123456789, Categoria.REGULAR);
//		insertarClienteBD(clienteInsertar);

		//8. ACTUALIZA LA INFORMACION DE ESE CLIENTE
//		clienteInsertar.setApellido2("lopez");
//		actualizarInfoCliente(clienteInsertar);

		//9. BUSQUE ESE CLIENTE SEGUN SU ID
//		buscarClientePorId(5);

		//10. ELIMINA DICHO CLIENTE
//		eliminarCliente(6);

	}

}
