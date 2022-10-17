
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
@Table(name = "Cabana")
public class Tcabana implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Not Null por Default
    private int id;
    
    @Column(name = "name", nullable = true, length = 45)//Null is ok
    private String name;
    
    @Column(name = "brand", nullable = true, length = 45) //Null is ok
    private String brand;
    
    @Column(name = "rooms", nullable = false) //Not Null
    private int rooms;
    
    @Column(name = "description", nullable = true, length = 250)//Nul is ok
    private String description;
    
    //FK Tcategoria
    @ManyToOne //Relacion de Muchas Cabanas pueden pertenecer a una misma categoria
    @JoinColumn(name = "category", nullable = true)//Se adiciona una columna Foranea category con informacion importada del campo Tcategory
    @JsonIgnoreProperties("cabins")//Del campo Foraneo "Tcategoria", ignore el sub-campo "cabins" para evitar la recursividad
    private Tcategoria category;//Representa un obj de la tabla Categoria
    
    //Relacion de una Cabana que puede tener muchos mensajes <>
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="cabin")//Comando Para que la List de Mensajes List<Tmensaje> sea muestrada en esta Tabla Tcabana y tambien esta sea invocada desde otra Table
    @JsonIgnoreProperties({"cabin","client"})//De las Tablas "mensajes" oculte "cabin" y "client" 
    @Column(name = "messages")
    private List<Tmensaje> messages;//Lista<> de los muchos posibles Mensajes que puede tener una cabana ya registrados en la entidad Tmensajes
    
    //Relacion de una Cabana que puede puede tener muchas reservaciones
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="cabin")//Comando Para que la List de Reservas List<Treservas> existentes, se muestre en esta Tabla Tcabana y tambien cuando Tcabana sea invocada desde otra Table
    @JsonIgnoreProperties({"cabin","client","score"})//De las Tablas "reservations" oculte los campos "cabin" y "client" 
    @Column(name = "reservations", nullable = true)
    private List<Treserva> reservations;//Lista<> de muchas las muchas posibles Reservaciones que puede tener una Cabana ya registradas en la entidad Treserva
    
}   
