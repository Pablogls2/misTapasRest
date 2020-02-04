package com.example.mistapasrest.modelos;

import javax.persistence.*;

@Entity
@Table (name="bares")
public class Bar {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name ="tapas",nullable = true,length = 500)
    private String tapas;
    @Column(name = "latitud", nullable = false, length = 50)
    private Double latitud;
    @Column(name = "longitud", nullable = false, length = 50)
    private Double longitud;
    @Column(name = "estrellas", nullable = false, length = 1)
    private int estrellas;

    @Column(name = "idUsuario", nullable = false, length = 3)
    private int idUsuario;

    @Lob
    @Column(name = "imagen")
    private String imagen;
    public Bar (){

    }

    public Bar(int id_bar,String nombre, Double latitud, Double longitud, int estrellas,String tapas, String imagen, int id_usuario) {
        this.id=id_bar;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estrellas = estrellas;
        this.tapas = tapas;
        this.imagen=imagen;
        this.idUsuario=id_usuario;
    }

    public int getId_usuario() {
        return idUsuario;
    }

    public void setId_usuario(int id_usuario) {
        this.idUsuario = id_usuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTapas() {
        return tapas;
    }

    public void setTapas(String tapas) {
        this.tapas = tapas;
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
