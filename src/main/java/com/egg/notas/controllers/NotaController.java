package com.egg.notas.controllers;

import com.egg.notas.Services.NotaService;
import com.egg.notas.entities.Nota;
import com.egg.notas.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaService notaservicio;

     // getmapping solo para traer
    @GetMapping("")
    public String formulario(Model modelo){
        Nota nota=  new Nota();
        nota.setUsuario(new Usuario());
        modelo.addAttribute("nota", nota);
        return "nota-form";
    }
    
    //postmapping se usa para recibir datos del html. 
    @PostMapping("/save")
    public String formularioData(@RequestParam("contenido") String contenido,
            @RequestParam("nombreUsuario") String nombre,
            @RequestParam("edadUsuario") Integer edad,
            Model modelo){
        Nota nota = new Nota();
        try {
            nota.setContenido(contenido);
            Usuario usuario = new Usuario();
            usuario.setEdad(edad);
            usuario.setNombre(nombre);
            nota.setUsuario(usuario);
            notaservicio.guardarNota(nota);  
            //volvemos a cargar el modelo con la nota para que no tire error el template
            modelo.addAttribute("nota",nota);
            return"nota-form";
        } catch (Exception ex) {
            //se atrapa el error en una variable y con model se la envia al front.
            ex.printStackTrace();
            //si tira un error el form se vuelve a 0 creamos un model usando el objeto nota para traer lo que 
            //tenemos guardado lo enviamos al front y usamos th:value en cada campo del formulario..
            modelo.addAttribute("nota",nota);
            modelo.addAttribute("error", ex.getMessage());
            return"nota-form";
        }
}
    @GetMapping("list")
    public String listaAll(Model model){
        List<Nota> notas= notaservicio.listAll();
        model.addAttribute("listaNotas", notas);
        return "nota-list";
    }
    }

