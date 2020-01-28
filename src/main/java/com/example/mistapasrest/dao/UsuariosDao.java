package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuario, Integer> {
}
