package hn.unah.Examen2.datos.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.Examen2.datos.demo.entities.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{
 
    
}
