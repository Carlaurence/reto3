package com.Ciclo3.EntityModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private int idMessage;
    
    @Column(name = "messageText", nullable = true, length = 250)//Not Null
    private String messageText; 
    
    @ManyToOne //Relacion de Muchos Mensajes pueden estar en una Cabana
    @JoinColumn(name = "cabin")//Se adiciona una columna mas que se va a llamar cabin
    @JsonIgnoreProperties({"messages", "reservations"})//De la tabla Tcabana, no me muestre los campos "messages", "reservations" pero si muestreme "category"
    private Tcabana cabin;//Representa un obj de la tabla Tcabana
    
    @ManyToOne //Relacion de Muchos Mensajes pueden ser escritos por un Cliente.
    @JoinColumn(name = "client")//Se adiciona una columna mas que se va a llamar client
    @JsonIgnoreProperties({"messages", "reservations"})
    private Tcliente client;//Representa un obj de la tabla Tcliente
    
    
}
