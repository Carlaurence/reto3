package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITcalificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioCalificacion {
    
    @Autowired
    private ITcalificacion repositoryTcalificacion;
    
}
