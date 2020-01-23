package com.example.mistapasrest.controlador;

import com.example.mistapasrest.modelos.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controlador {



    @GetMapping
    @RequestMapping(value="hola",method= RequestMethod.GET)
    public String hola(){return "hola chicos, vuestro lider avanza";}



    @RequestMapping(value="usuarios",method= RequestMethod.GET)
    public ResponseEntity<Usuario> getUsuario(){
       Usuario u= new Usuario (1,"pablo@hola.com","sdfsfAEF");

       return ResponseEntity.ok(u);
    }
}
