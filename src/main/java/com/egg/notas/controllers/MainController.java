
package com.egg.notas.controllers;

import com.egg.notas.Services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // si es la principal va vacia 
public class MainController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping("")
    public String index(){
        return "index";
    }
}
