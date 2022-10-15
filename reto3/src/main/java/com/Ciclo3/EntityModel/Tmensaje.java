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
@Table(name = "Mensaje")
public class Tmensaje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//Not Null por Default
    private int id;
    @Column(name = "messageText", nullable = true, length = 250)//Not Null
    private String messageText;     
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "client")//Se adiciona una columna mas que se va a llamar client
    private Tcliente client;//Representa un obj de la tabla Tcliente
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "cabin")//Se adiciona una columna mas que se va a llamar cabin
    private Tcabana cabin;//Representa un obj de la tabla Tcabana
    
    
}
