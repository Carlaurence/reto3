package com.Ciclo3.controller;

import com.Ciclo3.EntityModel.Tmensaje;
import com.Ciclo3.Service.ServicioMensaje;
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
@RequestMapping("/api/Message/")//Encargado de asignar la extension URL para acceder a los servicio de ServicioMessage
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorMensaje {
   
    @Autowired
    private ServicioMensaje serviceType;
    
    @GetMapping("/all") //Extension URL especifica para acceder al servicio GET ALL 
    public List<Tmensaje> findAllMensajes(){
        return serviceType.getMensajes();
    }
    
    @GetMapping("/Message/{id}") //Extension URL especifica para acceder al servicio GET BY ID
    public Tmensaje findMensajeById(@PathVariable int id){
        return serviceType.getMensajeById(id);
    }
    
    @PostMapping("/save") //Extension URL especifica para acceder al servicio SAVE/CREATE 
    public ResponseEntity addMensaje(@RequestBody Tmensaje mensaje){
        serviceType.saveMensaje(mensaje);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update") //Extension URL especifica para acceder al servicio UPDATE/ACTUALIZAR
    public ResponseEntity updateMensaje(@RequestBody Tmensaje mensaje){
        serviceType.updateMensaje(mensaje);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete") //Extension URL especifica para acceder al servicio DELETE/BORRAR
    public ResponseEntity deleteMensaje(@RequestBody Tmensaje mensaje){
        serviceType.deleteMensaje(mensaje.getId());
        return ResponseEntity.status(204).build();
    }
}
