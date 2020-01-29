package com.example.mistapasrest.controlador;

import com.example.mistapasrest.dao.UsuariosDao;
import com.example.mistapasrest.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/")
public class Controlador {

    @Autowired
    private UsuariosDao ud;

    @GetMapping
    @RequestMapping(value="hola",method= RequestMethod.GET)
    public String hola(){return "hola chicos, vuestro lider avanza";}



    @RequestMapping(value="testusuarios",method= RequestMethod.GET)
    public ResponseEntity<Usuario> getUsuario(){
       Usuario u= new Usuario ();

       return ResponseEntity.ok(u);
    }

    /**
     * Listamos todos los usuarios
     * @return List<Usuario></Usuario>
     */
    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {

        // Nos conectamos y realizamos el select
        List<Usuario> l = ud.findAll();
        // Devolvemos la ista de productos
        return ResponseEntity.ok(l);
    }


    @RequestMapping(value = "login/{nick}/{psw}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByNicknamePsw(@PathVariable("nick") String nick, @PathVariable("psw") String psw) {
        // Buscamos el producto por id

        Optional<Usuario> op = ud.findLogin(nick,psw);
        // Devolvemos el producto si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @RequestMapping(value = "login/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findbyId(@PathVariable("id") Integer id) {
        // Buscamos el producto por id

        Optional<Usuario> op = ud.findById(id);
        // Devolvemos el producto si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
