package com.egg.notas.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Nota {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String contenido;
    
    @ManyToOne(cascade = CascadeType.PERSIST)//para crear los 2 objetos ya que desde notas vamos a crear el objeto usuario
    private Usuario usuario;

    
}
