package com.Ciclo3.Service;

import com.Ciclo3.DaoRepository.ITcategoria;
import com.Ciclo3.EntityModel.Tcategoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioCategoria {
    @Autowired
    private ITcategoria repositoryTcategoria;
    
    public Tcategoria saveCategoria(Tcategoria categoria){
        return repositoryTcategoria.save(categoria);
    }
    
    public List<Tcategoria> getCategorias(){
        return (List<Tcategoria>) repositoryTcategoria.findAll();
    }
    
    public Tcategoria getCategoriaById(int id){
        return repositoryTcategoria.findById(id).orElse(null);
    }
    
    public Tcategoria updateCategoria(Tcategoria categoria){
        Tcategoria categoriaExistente = repositoryTcategoria.findById(categoria.getId()).orElse(null); 
        categoriaExistente.setName(categoria.getName());
        categoriaExistente.setDescription(categoria.getDescription());
        return repositoryTcategoria.save(categoriaExistente);
    }
    
    public String deleteCategoria(int id){
        repositoryTcategoria.deleteById(id);
        return "categoria removida" + id;
    }
}
