package com.Ciclo3.controller;

import com.Ciclo3.EntityModel.Tcabana;
import com.Ciclo3.Service.ServicioCabana;
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
@RequestMapping("/api/Cabin/")//Encargado de asignar la extension URL para acceder a los servicio de ServiciosCabana
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCabana {
    
    @Autowired
    private ServicioCabana serviceType;
    
    @GetMapping("/all") //Extension URL especifica para acceder al servicio GET ALL
    public List<Tcabana> findAllCabanas(){
        return serviceType.getCabanas();
    }
    
    @GetMapping("/Cabin/{id}") //Ext. URL especifica para acceder al servicio GET BY ID
    public Tcabana findCabanaById(@PathVariable int id){
        return serviceType.getCabanaById(id);
    }
    
    @PostMapping("/save") //Ext. URL especifica para acceder al servicio SAVE/CREATE
    public ResponseEntity addCabana(@RequestBody Tcabana cabana){
        serviceType.saveCabana(cabana);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update") //Ext. URL especifica para acceder al servicio UPDATE/ACTUALIZAR
    public ResponseEntity updateCabana(@RequestBody Tcabana cabana){
        serviceType.updateCabana(cabana);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete") //Ext. URL especifica para acceder al servicio DELETE/BORRAR
    public ResponseEntity deleteCabana(@RequestBody Tcabana cabana){
        serviceType.deleteCabana(cabana.getId());
        return ResponseEntity.status(204).build();
    }
}
