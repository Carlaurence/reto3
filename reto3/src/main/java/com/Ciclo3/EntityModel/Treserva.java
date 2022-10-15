package com.Ciclo3.EntityModel;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Reserva")
public class Treserva implements Serializable{
    @Id
    @GeneratedValue//AutoIncremental
    @Column(name = "id")//Not Null por Default
    private int id;
    
    @Column(name = "startDate", nullable = false)//Not Null
    private Date startDate;     
    
    @Column(name = "devolutionDate", nullable = false)//Not Null
    private Date devolutionDate;
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "client")//Se adiciona una columna mas que se va a llamar client
    private Tcliente client;//Representa un obj de la tabla Tcliente
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "cabin")//Se adiciona una columna mas que se va a llamar client
    private Tcabana cabin;//Representa un obj de la tabla Tcliente
}
