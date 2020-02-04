package com.example.mistapasrest.controlador;

import com.example.mistapasrest.dao.BaresDao;
import com.example.mistapasrest.dao.UsuariosDao;
import com.example.mistapasrest.modelos.Bar;
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
    @Autowired
    private BaresDao bd;

    @GetMapping
    @RequestMapping(value = "hola", method = RequestMethod.GET)
    public String hola() {
        return "hola chicos, vuestro lider avanza";
    }
    //

    @RequestMapping(value = "testusuarios", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getUsuario() {
        Usuario u = new Usuario();

        return ResponseEntity.ok(u);
    }

    /**
     * Listamos todos los usuarios
     *
     * @return List<Usuario></Usuario>
     */
    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {

        // Nos conectamos y realizamos el select
        List<Usuario> l = ud.findAll();
        // Devolvemos la ista de productos
        return ResponseEntity.ok(l);
    }

    /**
     * Metodo para realizar el login
     *
     * @param nick
     * @param psw
     * @return
     */
    @RequestMapping(value = "login/{nick}/{psw}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByNicknameAndPsw(@PathVariable("nick") String nick, @PathVariable("psw") String psw) {
        // Buscamos el producto por id

        Optional<Usuario> op = ud.findByNicknameAndPsw(nick, psw);
        // Devolvemos el producto si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    @RequestMapping(value = "comproRegistro/{nick}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByNickname(@PathVariable("nick") String nick) {
        // Buscamos el producto por id

        Optional<Usuario> op = ud.findByNickname(nick);
        // Devolvemos el producto si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }



    /**
     * Metodo para insertar un usuario nuevo
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "registro", method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
// Creamos un nuevo producto a partir de los datos una vez insertado
        Usuario p = ud.save(user);

//devolvemos el nuevo producto
        return ResponseEntity.ok(p);
    }

    @RequestMapping(value = "borrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("id") Integer id) {
        // Buscamos el producto por id
        Optional<Usuario> op = ud.findById(id);
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            // Le pasamos los datos
            Usuario p = op.get();
            ud.deleteById(id);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(value = "updateTok/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@PathVariable("id") Integer id, @RequestBody Usuario u) {
// Buscamos el producto por id
        Optional<Usuario> op = ud.findById(id);
// Devolvemos el producto si existe.
        if (op.isPresent()) {
// Le pasamos los datos
            Usuario p = op.get();
            p.setToken(u.getNombre());
            ud.save(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    /**
     * Metodo para insertar un nuevo bar
     *
     * @param bar
     * @return
     */
    @RequestMapping(value = "insertBar", method = RequestMethod.POST)
    public ResponseEntity<Bar> create(@RequestBody Bar bar) {
// Creamos un nuevo producto a partir de los datos una vez insertado
        Bar b = bd.save(bar);

//devolvemos el nuevo producto
        return ResponseEntity.ok(b);
    }


    @RequestMapping(value = "listBar/{idUsuario}/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<List<Bar>> findByIdUsuarioAndNombreStartsWith(@PathVariable("idUsuario") int idUsuario, @PathVariable("nombre") String nombre) {
        // Buscamos el producto por id

        List<Bar> lista = bd.findByIdUsuarioAndNombreStartsWith(idUsuario, nombre);
        // Devolvemos el producto si existe.
        return ResponseEntity.ok(lista);

    }

    /*@RequestMapping(value = "listBar/{id_bar}", method = RequestMethod.GET)
    public ResponseEntity<Bar> findById(@PathVariable("id_bar") int id_bar) {
        // Buscamos el producto por id

        Optional<Bar> op = bd.findById(id_bar);
        // Devolvemos el producto si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }*/




   @RequestMapping(value = "listBar/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Bar>> findAllByIdUsuario(@PathVariable("idUsuario") int id_usuario) {
        // Buscamos el producto por id

       List<Bar> lista = bd.findAllByIdUsuario(id_usuario);
        // Devolvemos el producto si existe.
       return ResponseEntity.ok(lista);

    }

}
