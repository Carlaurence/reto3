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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categoria")
public class Tcategoria implements Serializable{
    //Esta tabla Tcategoria contiene los campos:
    //int id, String (name, description), List<Cabanas> cabins
    //NOTA: No contiene columnas Foraneas @JoinColum
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrementable
    @Column(name = "id") //Not null por default
    private int id;
    @Column(name = "name", nullable = false, length = 45)//Not null
    private String name;
    @Column(name = "description", nullable = true, length = 250)// Null is ok
    private String description;
    
    //Pueden existir muchas Cabanas en una categoria
    //En una categoria puede estar contenidas muchas Cabanas 
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")//Comando para que la List de Cabanas List<Tcabana> que ya estan registradas en dicha tabla, sean muestrados en esta Tabla Tcategoria y tambien donde esta sea invocada desde otra Table
    @JsonIgnoreProperties({"category","messages","reservations"})//De las Tablas "Cabanas" oculte los campos "category", "messages" y "reservations" 
    @Column(name = "cabins")
    private List<Tcabana> cabins;
    //Lista<> de las muchas posibles Cabanas List<Tcabana> que puede tener la entidad Tcabana ya registradas
}
