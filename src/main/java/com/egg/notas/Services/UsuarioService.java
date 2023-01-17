
package com.egg.notas.Services;


import com.egg.notas.entities.Usuario;
import com.egg.notas.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {
@Autowired
private UsuarioRepository usuarioRepo;

public Usuario saveUsuario(Usuario usuario){
    
    return usuarioRepo.save(usuario);
}

public List<Usuario> listAll(){
    return usuarioRepo.findAll();
}

public Usuario buscarPorNombre(String nombre){
   
    return usuarioRepo.buscarPorNombre(nombre);
}
}
