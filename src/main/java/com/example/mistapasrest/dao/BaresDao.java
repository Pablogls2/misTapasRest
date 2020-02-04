package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Bar;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BaresDao extends JpaRepository<Bar, Integer> {


    List<Bar> findByIdUsuarioAndNombreStartsWith (@Param("idUsuario") int idUsuario, @Param("nombre") String nombre);

    List<Bar> findAllByIdUsuario(@Param("idUsuario") int idUsuario);

}
