package hn.unah.Examen2.datos.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.Examen2.datos.demo.entities.Cuenta;
import hn.unah.Examen2.datos.demo.services.impl.ClienteProductoServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api")
public class CuentaController {
    
    @Autowired
    private CuentaServiceImpl cuentaServiceImpl;

    @PostMapping("/cuenta/crear")
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta){
        return this.cuentaServiceImpl.crearCuenta(cuenta);
    }

}
