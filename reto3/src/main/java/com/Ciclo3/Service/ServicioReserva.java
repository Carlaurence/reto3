package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITreserva;
import com.Ciclo3.EntityModel.Treserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioReserva {
    @Autowired
    private ITreserva repositoryTreserva;
    
    public Treserva saveReserva(Treserva reserva){
        return repositoryTreserva.save(reserva);
    }
    
    public List<Treserva> getReservas(){
        return (List<Treserva>) repositoryTreserva.findAll();
    }
    
    public Treserva getReservaById(int id){
        return repositoryTreserva.findById(id).orElse(null);
    }
    
    public Treserva updateReserva(Treserva reserva){
        Treserva reservaExistente = repositoryTreserva.findById(reserva.getIdReservation()).orElse(null); 
        reservaExistente.setStartDate(reserva.getStartDate());
        reservaExistente.setDevolutionDate(reserva.getDevolutionDate());
        reservaExistente.setClient(reserva.getClient());
        reservaExistente.setCabin(reserva.getCabin());
        return repositoryTreserva.save(reservaExistente);
    }
    
    public String deleteReserva(int id){
        repositoryTreserva.deleteById(id);
        return "reserva removida" + id;
    }
}
