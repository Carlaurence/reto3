package com.Ciclo3.EntityModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reserva")
public class Treserva implements Serializable{
    @Id
    @GeneratedValue//AutoIncremental
    @Column(name = "id")//Not Null por Default
    private int idReservation;
    
    @Column(name = "startDate", nullable = false)//Not Null
    private Date startDate;     
    
    @Column(name = "devolutionDate", nullable = false)//Not Null
    private Date devolutionDate;
    
    @Column(name = "status", nullable = true)
    private final String status = "created";//Cada vez que se crea una reserva, por Default el status es created
    
    //FK Tcabana
    @ManyToOne //Relacion de Muchas reservas que puede tener una misma Cabana
    @JoinColumn(name = "cabin")//Se adiciona una columna mas que se va a llamar client
    @JsonIgnoreProperties({"reservations"})//No me muestre el campo reservation PERO si muestreme "category" y "messeges"
    private Tcabana cabin;//Representa un obj de la tabla Tcliente llamao por su id
    
    //FK Tcliente
    @ManyToOne //Relacion de Muchas reservas que pueden ser hechas por un client
    @JoinColumn(name = "client")//Se adiciona una columna mas que se va a llamar client
    @JsonIgnoreProperties({"messages", "reservations"})//No me muestre estos campos
    private Tcliente client;//Representa un obj de la tabla Tcliente llamado x su id
    
    //FK Tcalificacion
    @OneToOne(cascade={CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservations")//No me muestre el campo reservations de la tabla Treserva
    //@Column(name = "score")//NOTA: @Colum is not allowed in @OneToOne Property
    private Tcalificacion score;
    
}
