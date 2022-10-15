package com.Ciclo3.EntityModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UsuariosAdmin")
public class TusuariosAdmin implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Not Null por Default
    private int id;
    @Column(name = "name", nullable = false, length = 250) //Not Null
    private String name;
    @Column(name = "email", nullable = true, length = 45) //Null is ok
    private String email;
    @Column(name = "password", nullable = true, length = 45) //Null is ok
    private String password;
    
}
