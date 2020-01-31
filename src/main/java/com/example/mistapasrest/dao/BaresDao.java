package com.example.mistapasrest.dao;

import com.example.mistapasrest.modelos.Bar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BaresDao extends JpaRepository<Bar, Integer> {

}
