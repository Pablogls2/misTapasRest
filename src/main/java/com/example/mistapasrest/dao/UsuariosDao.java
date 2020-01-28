package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {

    @Query("SELECT t FROM Usuario t where t.nickname = :nickname AND t.psw = :nickname")
    public Optional<Usuario> findbyNickPsw(@Param("nickname") String nick,
                                                    @Param("psw") String psw);



}
