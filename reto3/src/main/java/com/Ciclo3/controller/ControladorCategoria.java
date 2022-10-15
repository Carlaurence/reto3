package com.Ciclo3.controller;

import com.Ciclo3.EntityModel.Tcategoria;
import com.Ciclo3.Service.ServicioCategoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/*NOTA IMPORTANTE: EL CONTROLADO SE ENCARGA UNICAMENTE DE DIRECCIONAR 
LOS REQUESTING DE CADA SERVICIO MEDIANTE LA ASIGNACION DE UNA EXTENSION 
DE LA URL.*/

@RestController
@RequestMapping("/api/Category/")//Encargado de asignar la extension URL para acceder a los servicio de ServiciosCabana
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCategoria {
    @Autowired
    private ServicioCategoria serviceType;
    
    @GetMapping("/all") //Extension URL especifica para acceder al servicio GET ALL
    public List<Tcategoria> findAllCategorias(){
        return serviceType.getCategorias();
    }
    
    @GetMapping("/Category/{id}") //Ext. URL especifica para acceder al servicio GET BY ID
    public Tcategoria findCategoriaById(@PathVariable int id){
        return serviceType.getCategoriaById(id);
    }
    
    @PostMapping("/save") //Ext. URL especifica para acceder al servicio SAVE/CREATE
    public ResponseEntity addCategoria(@RequestBody Tcategoria categoria){
        serviceType.saveCategoria(categoria);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update") //Ext. URL especifica para acceder al servicio UPDATE/ACTUALIZAR
    public ResponseEntity updateCategoria(@RequestBody Tcategoria categoria){
        serviceType.updateCategoria(categoria);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete") //Ext. URL especifica para acceder al servicio DELETE/BORRAR
    public ResponseEntity deleteCategoria(@RequestBody Tcategoria categoria){
        serviceType.deleteCategoria(categoria.getId());
        return ResponseEntity.status(204).build();
    }
}
