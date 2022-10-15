package com.Ciclo3.controller;

import com.Ciclo3.EntityModel.Tcliente;
import com.Ciclo3.Service.ServicioCliente;
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
@RequestMapping("/api/Client/")//Encargado de asignar la extension URL para acceder a los servicio de ServicioCliente
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCliente {
    @Autowired
    private ServicioCliente serviceType;
    
    @GetMapping("/all") //Extension URL especifica para acceder al servicio GET ALL 
    public List<Tcliente> findAllClientes(){
        return serviceType.getClientes();
    }
    
    @GetMapping("/Client/{id}") //Extension URL especifica para acceder al servicio GET BY ID
    public Tcliente findClienteById(@PathVariable int id){
        return serviceType.getClienteById(id);
    }
    
    @PostMapping("/save") //Extension URL especifica para acceder al servicio SAVE/CREATE 
    public ResponseEntity addCliente(@RequestBody Tcliente cliente){
        serviceType.saveCliente(cliente);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update") //Extension URL especifica para acceder al servicio UPDATE/ACTUALIZAR
    public ResponseEntity updateCliente(@RequestBody Tcliente cliente){
        serviceType.updateCliente(cliente);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete") //Extension URL especifica para acceder al servicio DELETE/BORRAR
    public ResponseEntity deleteCliente(@RequestBody Tcliente cliente){
        serviceType.deleteCliente(cliente.getIdClient());
        return ResponseEntity.status(204).build();
    }
}
