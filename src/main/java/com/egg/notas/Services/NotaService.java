
package com.egg.notas.Services;

import com.egg.notas.entities.Nota;
import com.egg.notas.entities.Usuario;

import com.egg.notas.repositories.NotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepo;
    @Autowired
    private UsuarioService usuarioSer;
    
    public Nota guardarNota(Nota nota) throws Exception{
        if (nota.getContenido().isEmpty()||nota.getContenido()==null) {
            throw new Exception("la nota no puede estar vacia");
        }
        
        if (nota.getUsuario().getNombre().isEmpty()) {
            throw new Exception("el nombre no puede estar vacio");
        }
        if (nota.getUsuario().getEdad()==null) {
            throw new Exception("la edad no puede estar vacia");
        }
        
        if (nota.getUsuario().getEdad()==null) {
            throw new Exception("la edad no puede estar vacia");
        }
        if (nota.getUsuario().getEdad()<1) {
            throw new Exception("la edad no puede ser 0");
        }
        //buscamos si el usuario existe si existe no lo vuelve a crear
        Usuario usuario = usuarioSer.buscarPorNombre(nota.getUsuario().getNombre());
        if (usuario !=null) {
            nota.setUsuario(usuarioSer.buscarPorNombre(nota.getUsuario().getNombre()));            
        }
        
      return notaRepo.save(nota);
    }
    
    public List<Nota> listAll(){
        return notaRepo.findAll();
    }
}
