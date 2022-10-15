package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITusuariosAdmin;
import com.Ciclo3.EntityModel.TusuariosAdmin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioUsuario {
    @Autowired
    private ITusuariosAdmin repositoryTusuariosAmin; 
    
    public TusuariosAdmin saveUsuarioAdmin(TusuariosAdmin usuariosAdmin){
        return repositoryTusuariosAmin.save(usuariosAdmin);
    }
    
    public List<TusuariosAdmin> getUsuariosAdmin(){
        return (List<TusuariosAdmin>) repositoryTusuariosAmin.findAll();
    }
    
    public TusuariosAdmin getUsuarioAdminById(int id){
        return repositoryTusuariosAmin.findById(id).orElse(null);
    }
    
    public TusuariosAdmin updateUsuariosAdmin(TusuariosAdmin usuariosAdmin){
        TusuariosAdmin usuarioAdminExistente = repositoryTusuariosAmin.findById(usuariosAdmin.getId()).orElse(null);
        usuarioAdminExistente.setName(usuariosAdmin.getName());
        usuarioAdminExistente.setEmail(usuariosAdmin.getEmail());
        usuarioAdminExistente.setPassword(usuariosAdmin.getPassword());   
        return repositoryTusuariosAmin.save(usuarioAdminExistente);
    }
    
    public String deleteUsuarioAdmin(int id){
        repositoryTusuariosAmin.deleteById(id);
        return "Usuario Administrativo removido" + id;
    }
    
    
    
}
