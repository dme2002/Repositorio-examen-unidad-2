package hn.unah.Examen2.datos.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.Examen2.datos.demo.entities.Cliente;

import hn.unah.Examen2.datos.demo.entities.Movimientos;

import hn.unah.Examen2.datos.demo.repositories.ClienteRepository;
import hn.unah.Examen2.datos.demo.repositories.MovimientoRepository;

import hn.unah.Examen2.datos.demo.services.ClienteProductoService;

@Service
public class CuentaServiceImpl implements ClienteProductoService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
     public Cuenta crearCuenta(Cuenta cuenta) {
         Cliente nvoCliente = null;
         
         if(null != cuenta.getCliente()){
             nvoCliente = cuenta.getCliente();            
             this.clienteRepository.save(nvoCliente);
         }


        cuenta.setCliente(nvoCliente);
        

         Cuenta cuenta2 = this.cuentaRepository.save(clienteProducto);

         if(null != clienteProducto.getMovimientos()){
             for (Movimientos movimiento:clienteProducto.getMovimientos()) {
               movimiento.setClienteProducto(clienteProducto2);
                 this.movimientoRepository.save(movimiento);
             }
    //     }

    //     return clienteProducto2;
    // }



    
    
}
