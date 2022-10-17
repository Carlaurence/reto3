package com.Ciclo3.EntityModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Calificacion")
public class Tcalificacion implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Not Null por Default
    private int id;
    @Column(name = "score", length = 5)
    private int score;
    @Column(name = "messageText", length = 250)
    private String messageText; 
    
    //Relacion de una calificacion para una reserva.
    //Debe de exisitir una reserva para que exista una calificacion
    @OneToOne
    @JsonIgnoreProperties({"cabin","client","score"})//De la tabla TReserva, oculte el campo "score" 
    //@Column(name = "reservation")//NOTA: @Colum is not allowed with @OneToOne
    private Treserva reservation;
    
    
}
