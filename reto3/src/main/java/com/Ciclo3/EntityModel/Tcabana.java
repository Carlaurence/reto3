    
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
@Table(name = "Cabana")
public class Tcabana implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Not Null por Default
    private int id;
    @Column(name = "brand", nullable = true, length = 45) //Null is ok
    private String brand;
    @Column(name = "rooms", nullable = false) //Not Null
    private int rooms;
    @Column(name = "name", nullable = true, length = 45)//Null is ok
    private String name;
    @Column(name = "description", nullable = true, length = 250)//Nul is ok
    private String description;
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "category")//Se adiciona una columna mas que se va a llamar category
    private Tcategoria category;//Representa un obj de la tabla Categoria
}
