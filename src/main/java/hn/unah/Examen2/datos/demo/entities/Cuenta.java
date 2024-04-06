package hn.unah.Examen2.datos.demo.entities;

import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name = "cuentas")
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numerocuenta")
    private long numeroCuenta;
    

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name="dni", referencedColumnName = "dni")
    private Cliente cliente;    

    
    @Column(name="fechaapertura")
    private LocalDate fechaApertura;
    
    private char estado;
   
    private double saldo;

    private char sobregiro;

    @JsonManagedReference
    @OneToMany(mappedBy = "cuenta", cascade =  CascadeType.ALL)        
    private List<Movimientos> movimientos; 
}
