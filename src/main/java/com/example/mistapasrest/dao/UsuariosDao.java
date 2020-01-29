package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {

   /* @Query("SELECT t FROM Usuario t where t.nickname = :nickname AND t.psw = :nickname")
    public Optional<Usuario> findbyNickPsw(@Param("nickname") String nick,
                                                    @Param("psw") String psw);*/


    @Query("SELECT u.nickname,u.psw,u.email FROM Usuario u where u.nickname = :nick and u.psw=:psw")
    Optional<Usuario> findLogin(@Param("nick") String nick, @Param("psw") String psw);

}
