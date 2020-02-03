package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Bar;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BaresDao extends JpaRepository<Bar, Integer> {


    Optional<Bar> findByIdAndNombre (@Param("id_bar") int id_bar, @Param("nombre") String nombre);


}
