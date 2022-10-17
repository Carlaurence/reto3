package com.Ciclo3.EntityModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
public class Tcliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncremental
    @Column(name = "idClient") //Not Null por Default
    private int idClient;
    
    @Column(name = "email", nullable = true, length = 45) //Null is ok
    private String email;
    
    @Column(name = "password", nullable = true, length = 45) //Null is ok
    private String password;
    
    @Column(name = "name", nullable = false, length = 250) //Not Null
    private String name;    
    
    @Column(name = "age", nullable = true) //Null is ok
    private int age;
    
    
    //Relacion de un cliente que puede escribir muchos mensajes
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")//Comando Para que la List de Mensajes List<Tmensaje> sea muostrada en esta Tabla "Tcliente" y tambien cuando esta sea invocada desde otra Table
    @Column(name = "messages")
    @JsonIgnoreProperties({"cabin","client"})//De la tabla Mensajes, oculte el campo "cliente" y "cabana" 
    private List<Tmensaje> messages;//Lista<> de los muchos posibles Mensajes que puede escribir un cliente
    
    //Relacion de un cliente que puede realizar muchas reservaciones, pero una reservacion no puede ser hecha por muchos clientes.
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")//Comando Para que la List de Reservas List<Treserva> sea mostrada en esta Tabla "Tcliente" y tambien cuando esta sea invocada desde otra Table
    @JsonIgnoreProperties({"cabin","client","score"})//De la tabla Reserva, oculte el campo "cliente", "cabana" y "score"
    @Column(name = "reservations")
    private List<Treserva> reservations;//Lista<> de las muchos posibles Reservaciones que puede realizar un cliente 
}


