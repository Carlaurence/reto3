package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITcabana;
import com.Ciclo3.EntityModel.Tcabana;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioCabana {
    @Autowired
    private ITcabana repositoryTcabana;//Creacion Objeto "repositoryTcabana" instanciado desde la clase ITcabana{}
    
    /*Por medio del objeto "repositoryTcabana" podemos llamar a todos los metodos 
    contenidos en el CRUDRepository de SpringBoot
    */
    
    //Creacion de los Metodos CRUD para este ServicioCabana
    
    //Metodo "SAVE" - crear una Cabana
    public Tcabana saveCabana(Tcabana cabana){//Recibe como parametros un Objeto tipo Tcabana
        return repositoryTcabana.save(cabana);//Guarda el registro en la DB
    }
    
    //Metodo GET_ALL - consultar todos los registros
    public List<Tcabana> getCabanas(){//No recibe arg
        return (List<Tcabana>) repositoryTcabana.findAll();//Return una lista con todos los registros
    }
    
    //Metodo GET BY ID - consultar una cabana por id
    public Tcabana getCabanaById(int id){
        return repositoryTcabana.findById(id).orElse(null);
    }
    
    //Metodo UPDATE - actualiza un registro existente
    public Tcabana updateCabana(Tcabana cabana){
        /*El arg entrante 'cabana', contiene un id ya existente(el cual no puede ser modificado), 
        pero el resto de la informacion viene ya con las modificaciones ingresadas
        por el usuario*/
        
        /*la var cabanaExistente inicialmente se utilizara para almacenar 
        un registro ya existente de tipo Tcabana, llamado mediante el id*/
        Tcabana cabanaExistente = repositoryTcabana.findById(cabana.getId()).orElse(null);
        
        //Ahora a ese registro existente, le setteamos los nuevos datos 
        cabanaExistente.setBrand(cabana.getBrand());
        cabanaExistente.setRooms(cabana.getRooms());
        cabanaExistente.setCategory(cabana.getCategory());
        cabanaExistente.setName(cabana.getName());
        cabanaExistente.setDescription(cabana.getDescription());
        
        //El id no se puede cambiar, por eso no se incluye en los metodos set

        return repositoryTcabana.save(cabanaExistente);//Se guarda/save con la informacion que contiene la var cabanaExistente
    }
    
    //Metodo DELETE - elimina un registro existente mediante su id
    public String deleteCabana(int id){
        repositoryTcabana.deleteById(id);
        return "cabana removido" + id;
    }
    
    
    
}
