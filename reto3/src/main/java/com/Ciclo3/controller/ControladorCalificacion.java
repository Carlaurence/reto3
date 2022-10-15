package com.Ciclo3.controller;

import com.Ciclo3.Service.ServicioCalificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Score/")//Encargado de asignar la extension URL para acceder a los servicio de ServiciosCabana
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCalificacion {
    
    @Autowired
    private ServicioCalificacion serviceType;
    
    
    
}
