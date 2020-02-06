package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Bar;

import com.example.mistapasrest.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BaresDao extends JpaRepository<Bar, Integer> {



    //buscamos todos los bares por el id de el usuario
    List<Bar> findAllByIdUsuario(@Param("idUsuario") int idUsuario);





}
