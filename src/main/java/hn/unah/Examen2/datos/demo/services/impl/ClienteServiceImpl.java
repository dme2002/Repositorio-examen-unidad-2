package hn.unah.Examen2.datos.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.Examen2.datos.demo.entities.Cliente;
import hn.unah.Examen2.datos.demo.entities.Cuenta;
import hn.unah.Examen2.datos.demo.repositories.ClienteRepository;
import hn.unah.Examen2.datos.demo.repositories.CuentaRepository;
import hn.unah.Examen2.datos.demo.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }


    @Override
    public Cliente crearCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorDni(String dni) {
        return this.clienteRepository.findById(dni);
    }

    @Override
    public Cliente actualizarCliente(String dni, Cliente cliente) {
        Cliente clienteActualizar = this.clienteRepository.findById(dni).get();

        if(null != clienteActualizar){
            clienteActualizar.setCorreo(cliente.getCorreo());
            clienteActualizar.setApellido(cliente.getApellido());
            clienteActualizar.setNombre(cliente.getNombre());
            this.clienteRepository.save(clienteActualizar);
        }

        return clienteActualizar;
    }

    @Override
    public String eliminarCliente(String dni) {

        if(this.clienteRepository.existsById(dni)){
            this.clienteRepository.deleteById(dni);
            return "Cliente eliminado";
        }        

        return "No existe el cliente";
    }

     @Override
     public Cliente agregarCuentaCliente(String dni, long numeroCuenta) {
         if(this.clienteRepository.existsById(dni)){
             Cliente clienteActualizar = this.clienteRepository.findById(dni).get();
             if(this.cuentaRepository.existsById(numeroCuenta) && this.cuentaRepository.getEstado == true){
                 Cuenta nvaCuenta = new Cuenta();
                 nvaCuenta.setEstado(false);
                 nvaCuenta.setSaldo(5000);
                 nvaCuenta.setCliente(this.clienteRepository.findById(dni).get());
               
                 clienteActualizar.getCuentas().add(nvaCuenta);
                 this.cuentaRepository.save(nvaCuenta);
                return clienteActualizar;
                 
                 this.cuentaRepository.save(nvaCuenta);
                 return nvaCuenta.getCliente();
             }
         }

         return null;
     }

    
}
