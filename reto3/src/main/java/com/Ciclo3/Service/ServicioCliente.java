package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITcliente;
import com.Ciclo3.EntityModel.Tcliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioCliente {
    
    @Autowired
    //se debe importar el paquete que contiene a ITcliente
    private ITcliente repositoryTcliente; //Creacion Objeto "repositoryTcliente" instanciado desde la clase ITcliente{}

    /*Por medio del objeto "repositoryTcliente" podemos llamar a todos los metodos 
    contenidos en el CRUDRepository de SpringBoot*/
    
    //Creacion de los Metodos CRUD para este ServicioCliente
    
    //Metodo "SAVE" - crear un new cliente 
    public Tcliente saveCliente(Tcliente cliente){//Recibe como parametros un Objeto tipo Tcliente
        return repositoryTcliente.save(cliente);//Guarda el new registro en la DB
    }
    
    //Metodo GET_ALL - consultar todos los registros
    public List<Tcliente> getClientes(){//No recibe arg
        return (List<Tcliente>) repositoryTcliente.findAll();//Return una lista con todos los registros de clientes existente en la DB
    }
    
    //Metodo GET BY ID - consultar un cliente por id
    public Tcliente getClienteById(int id){
        return repositoryTcliente.findById(id).orElse(null);
    }
    
    //Metodo UPDATE - actualiza un registro existente
    public Tcliente updateCliente(Tcliente cliente){
        /*El arg entrante 'cliente', contiene un id ya existente(el cual no puede ser modificado), 
        pero el resto de la informacion viene ya con las modificaciones ingresadas
        por el usuario*/
        
        /*la var clienteExistente inicialmente se utilizara para almacenar 
        un registro ya existente de tipo Tcliente, llamado mediante el id*/
        Tcliente clienteExistente = repositoryTcliente.findById(cliente.getIdClient()).orElse(null);
        
        //Ahora a ese registro existente, le setteamos los nuevos datos del cliente 
        clienteExistente.setName(cliente.getName());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setPassword(cliente.getPassword());
        clienteExistente.setAge(cliente.getAge());
        
        //El id no se puede cambiar, por eso no se incluye en los metodos set
        
        return repositoryTcliente.save(clienteExistente);//Se guarda/save con la informacion que contiene la var clienteExistente
    }
    
    //Metodo DELETE - elimina un registro existente mediante su id
    public String deleteCliente(int id){
        repositoryTcliente.deleteById(id);
        return "cliente removido" + id;
    }
}
