package hn.unah.Examen2.datos.demo.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="cliente")
public class Cliente {
    
    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="iddireccion", referencedColumnName = "iddireccion")
    private Direccion direccion; 

    @OneToMany(mappedBy = "cliente")    
    private List<Cuenta> cuentas;

}
