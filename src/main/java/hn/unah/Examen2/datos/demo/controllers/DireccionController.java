package hn.unah.Examen2.datos.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.Examen2.datos.demo.entities.Direccion;
import hn.unah.Examen2.datos.demo.services.impl.DireccionServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class DireccionController {
    
    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/direccion/crear")
    public Direccion crearDireccion(@RequestBody Direccion direccion) {
        return this.direccionServiceImpl.crearDireccion(direccion);
    }
}
