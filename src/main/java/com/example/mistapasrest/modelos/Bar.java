package com.example.mistapasrest.modelos;

import javax.persistence.*;

@Entity
@Table (name="bares")
public class Bar {

    @Id
    @Column(name = "id_bar")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "latitud", nullable = false, length = 50)
    private Double latitud;
    @Column(name = "longitud", nullable = false, length = 50)
    private Double longitud;
    @Column(name = "estrellas", nullable = false, length = 1)
    private int estrellas;

    public Bar (){

    }

    public Bar(String nombre, Double latitud, Double longitud, int estrellas) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estrellas = estrellas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
}