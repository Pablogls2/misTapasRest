package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {

   //para comprobar el login
    Optional<Usuario> findByNicknameAndPsw (@Param("nick") String nick, @Param("psw") String psw);

    //para comprobar que al registrar no se repita el nickname
    Optional<Usuario> findByNickname (@Param("nick") String nick);
    //para comprobar el token guardado en el dispositivo y el de la base de datos
    Optional<Usuario> findByToken(@Param( "token") String token);

}
