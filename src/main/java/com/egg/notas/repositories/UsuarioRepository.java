
package com.egg.notas.repositories;


import com.egg.notas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
   public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    //jpql se hace un select primero un alias de la clase from la clase con mayuscula el alias y el atributo a buscar 
    //=: a la variable que pasamos por parametro 
    @Query("select u from Usuario u where u.nombre = :nombre")
    public Usuario buscarPorNombre(@Param("nombre") String nombre);
    
}
