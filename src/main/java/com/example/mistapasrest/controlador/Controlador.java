package com.example.mistapasrest.controlador;

import com.example.mistapasrest.dao.UsuariosDao;
import com.example.mistapasrest.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
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
        //Producto p = new Producto(1L,"Producto");
        //ArrayList<Producto> l = new ArrayList<Producto>();
        // l.add(p);
        // Nos conectamos y realizamos el select
        List<Usuario> l = ud.findAll();
        // Devolvemos la ista de productos
        return ResponseEntity.ok(l);
    }

    @RequestMapping(value = "usuario/{nickname}" , "usuario/{psw}", method = RequestMethod.GET)
    public ResponseEntity<Producto> findById(@PathVariable("id") Long id) {
        // Buscamos el producto por id
        Optional<Producto> op = pd.findById(id);
        // Devolvemos el producto si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
