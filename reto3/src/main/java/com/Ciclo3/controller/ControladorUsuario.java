package com.Ciclo3.controller;

import com.Ciclo3.EntityModel.TusuariosAdmin;
import com.Ciclo3.Service.ServicioUsuario;
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
@RequestMapping("/api/Admin/")//Encargado de asignar la extension URL para acceder a los servicio de ServicioCliente
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorUsuario {
    @Autowired
    private ServicioUsuario serviceType;
    
    @GetMapping("/all") //Extension URL especifica para acceder al servicio GET ALL 
    public List<TusuariosAdmin> findAllUsuariosAdmin(){
        return serviceType.getUsuariosAdmin();
    }
    
    @GetMapping("/Admin/{id}") //Extension URL especifica para acceder al servicio GET BY ID
    public TusuariosAdmin findUsuarioAdminById(@PathVariable int id){
        return serviceType.getUsuarioAdminById(id);
    }
    
    @PostMapping("/save") //Extension URL especifica para acceder al servicio SAVE/CREATE 
    public ResponseEntity addUsuarioAdmin(@RequestBody TusuariosAdmin usuariosAdmin){
        serviceType.saveUsuarioAdmin(usuariosAdmin);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update") //Extension URL especifica para acceder al servicio UPDATE/ACTUALIZAR
    public ResponseEntity updateUsuarioAdmin(@RequestBody TusuariosAdmin usuariosAdmin){
        serviceType.updateUsuariosAdmin(usuariosAdmin);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete") //Extension URL especifica para acceder al servicio DELETE/BORRAR
    public ResponseEntity deleteUsuarioAdmin(@RequestBody TusuariosAdmin usuariosAdmin){
        serviceType.deleteUsuarioAdmin(usuariosAdmin.getId());
        return ResponseEntity.status(204).build();
    }
}
