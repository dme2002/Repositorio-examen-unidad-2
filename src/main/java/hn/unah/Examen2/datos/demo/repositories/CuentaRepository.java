package hn.unah.Examen2.datos.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.Examen2.datos.demo.entities.Cuenta;
import hn.unah.Examen2.datos.demo.entities.Movimientos;

public interface CuentaRepository extends CrudRepository<Cuenta, Long>{
    public List<Movimientos> getByCuenta(String numeroCuenta);
}
