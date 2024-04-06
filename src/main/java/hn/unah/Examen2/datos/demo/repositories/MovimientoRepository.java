package hn.unah.Examen2.datos.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.Examen2.datos.demo.entities.Movimientos;

public interface MovimientoRepository extends CrudRepository<Movimientos, Long>{
    
}
