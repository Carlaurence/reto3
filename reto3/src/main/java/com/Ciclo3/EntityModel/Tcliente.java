package com.Ciclo3.EntityModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "name", nullable = false, length = 250) //Not Null
    private String name;
    @Column(name = "email", nullable = true, length = 45) //Null is ok
    private String email;
    @Column(name = "password", nullable = true, length = 45) //Null is ok
    private String password;
    @Column(name = "age", nullable = true) //Null is ok
    private int age;
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "messages")//Se adiciona una columna mas que se va a llamar messages
    private Tmensaje messages;//Representa un obj de la tabla Mensajes
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "reservations")//Se adiciona una columna mas que se va a llamar reservation
    private Treserva reservations;//Representa un obj de la tabla Reserva    
}


