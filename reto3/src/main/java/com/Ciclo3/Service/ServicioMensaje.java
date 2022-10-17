package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITmensaje;
import com.Ciclo3.EntityModel.Tmensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioMensaje {
    
    @Autowired
    private ITmensaje repositoryTmensaje;
    
    public Tmensaje saveMensaje(Tmensaje mensaje){return repositoryTmensaje.save(mensaje);}
    
    public List<Tmensaje> getMensajes(){return (List<Tmensaje>) repositoryTmensaje.findAll();}
    
    public Tmensaje getMensajeById(int id){return repositoryTmensaje.findById(id).orElse(null);}
    
    public  Tmensaje updateMensaje(Tmensaje mensaje){//Aqui entra la nueva informacion
        Tmensaje mensajeExistente = repositoryTmensaje.findById(mensaje.getIdMessage()).orElse(null);
        mensajeExistente.setMessageText(mensaje.getMessageText());
        mensajeExistente.setClient(mensaje.getClient());
        mensajeExistente.setCabin(mensaje.getCabin());
        return repositoryTmensaje.save(mensajeExistente);
    }
    
    public String deleteMensaje(int id){
        repositoryTmensaje.deleteById(id);
        return "Mensaje borrado "+ id;
    }
}
