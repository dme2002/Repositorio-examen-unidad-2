package hn.unah.Examen2.datos.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.Examen2.datos.demo.entities.Cliente;
import hn.unah.Examen2.datos.demo.services.impl.ClienteServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/cliente/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return this.clienteServiceImpl.crearCliente(cliente);
    }

    @GetMapping("/cliente/obtener")    
    public List<Cliente> obtenerClientes(){
        return this.clienteServiceImpl.obtenerClientes();
    }

    @PutMapping("/cliente/actualizar/{id}")
    public Cliente actualizaCliente(@PathVariable String id, 
                                @RequestBody Cliente cliente) {
                
        return this.clienteServiceImpl.actualizarCliente(id, cliente);
    }

    @GetMapping("/cliente/obtenerPorID")
    public Optional<Cliente> buscarClientePorDni(@RequestParam String dni) {
        return this.clienteServiceImpl.buscarClientePorDni(dni);
    }
    
    
    @DeleteMapping("/cliente/eliminar")
    public String eliminarCliente(@RequestParam String dni) {
        return this.clienteServiceImpl.eliminarCliente(dni);
    }


    //Aqui le cambie el requestparam por pathvariable 
    @PutMapping("/cliente/agregarCuenta")
    public Cliente agregarProducto(@PathVariable(name = "dni") String dni, 
                                   @RequestParam(name="numeroCuenta") long codigoTipoProducto) {
        return this.clienteServiceImpl.agregarCuentaCliente(dni, codigoTipoProducto);        
    }

}
