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

    /**
     * Primer metodo de la clase que hicimos de prueba
     * @return String con un mensaje de prueba
     */
    @GetMapping
    @RequestMapping(value = "hola", method = RequestMethod.GET)
    public String hola() {
        return "hola chicos, vuestro lider avanza";
    }



    /**
     * Listamos todos los usuarios
     *
     * @return List<Usuario></Usuario>
     */
    @RequestMapping(value = "usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {

        // Se conecta y busca los usuarios
        List<Usuario> l = ud.findAll();
        // Devolvemos la ista de usuarios
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
        // Buscamos el usuario  por usuario y contraseña

        Optional<Usuario> op = ud.findByNicknameAndPsw(nick, psw);
        // Devolvemos el usuario si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    /**
     * Método para comprobar que existe el nickname a la hora de hacer un registro
     * @param nick
     * @return
     */
    @RequestMapping(value = "comproRegistro/{nick}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByNickname(@PathVariable("nick") String nick) {
        // Buscamos el usuario por usuario

        Optional<Usuario> op = ud.findByNickname(nick);
        // Devolvemos el usuario si existe.
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
     * @return Usuario
     */
    @RequestMapping(value = "registro", method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody Usuario user) {
        //Se crea un usuario nuevo a partir del que ha llegado
        Usuario p = ud.save(user);

        //devolvemos el nuevo usuario
        return ResponseEntity.ok(p);
    }

    /**
     * Método para borrar un usuario
     * @param id
     * @return Usuario
     */
    @RequestMapping(value = "borrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("id") Integer id) {
        // Buscamos el usuario por id
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

    /**
     * Método para actualizar el Token del usuario al iniciar sesion
     * @param id
     * @param u
     * @return Usuario
     */
   @RequestMapping(value = "updateTok/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@PathVariable("id") Integer id, @RequestBody Usuario u) {
    // Buscamos el usuario por id
        Optional<Usuario> op = ud.findById(id);
    // Devolvemos el usuario si existe.
        if (op.isPresent()) {
    // Le pasamos los datos
            Usuario p = op.get();
            p.setToken(u.getToken());
            ud.save(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Método para comprobar el token que el usuario tiene en sqlite sea igual que el de la bbdd de Rest
     * @param token
     * @return Usuario
     */
    @RequestMapping(value = "comproToken/{token}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByToken(@PathVariable("token") String token) {
        // Buscamos el usuario  por token

        Optional<Usuario> op = ud.findByToken(token);
        // Devolvemos el usuario si existe.
        if (op.isPresent()) {
            return ResponseEntity.ok(op.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }


    /**
     * Método para devolver todos los bares
     * @return List<Bar>
     */
    @RequestMapping(value = "bares", method = RequestMethod.GET)
    public ResponseEntity<List<Bar>> findAllBar() {

        // Nos conectamos y realizamos el select
        List<Bar> l = bd.findAll();
        // Devolvemos la ista de bares
        return ResponseEntity.ok(l);
    }


    /**
     * Metodo para insertar un nuevo bar
     *
     * @param bar
     * @return Bar
     */
    @RequestMapping(value = "insertBar", method = RequestMethod.POST)
    public ResponseEntity<Bar> create(@RequestBody Bar bar) {
    // Creamos un nuevo bar a partir de los datos una vez insertado
        Bar b = bd.save(bar);

    //devolvemos el bar
        return ResponseEntity.ok(b);
    }


    /**
     * Método para listar todos los bares de un usuario
     * @param id_usuario
     * @return List <Bar>
     */
   @RequestMapping(value = "listBar/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Bar>> findAllByIdUsuario(@PathVariable("idUsuario") int id_usuario) {
        // Buscamos los bares de la id del usuario dado

       List<Bar> lista = bd.findAllByIdUsuario(id_usuario);
        // Devolvemos la lista de bares
       return ResponseEntity.ok(lista);

    }


    /**
     * Método para borrar un bar dada su id
     * @param id
     * @return Bar
     */
    @RequestMapping(value = "deleteBar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Bar> deleteBar(@PathVariable("id") Integer id) {
        // Buscamos el bar por id
        Optional<Bar> op = bd.findById(id);
        // si existe lo borramos y devolvemos
        if (op.isPresent()) {
            // Le pasamos los datos
            Bar p = op.get();
            bd.deleteById(id);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
