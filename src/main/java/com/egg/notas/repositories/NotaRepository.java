
package com.egg.notas.repositories;

import com.egg.notas.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository  extends JpaRepository<Nota, String>{
    
}
