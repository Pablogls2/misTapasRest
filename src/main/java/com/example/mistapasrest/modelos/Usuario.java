package com.example.mistapasrest.modelos;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table (name="usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;
    @Column(name = "nickname", nullable = false, length = 50)
    private String nombre;
    @Column(name = "nickname", nullable = false, length = 50)
    private String email;
    @Column(name = "nickname", nullable = false, length = 50)
    private String psw;
    @Column(name = "nickname", nullable = false, length = 50)
    private int id_bar;

    public Usuario() {
    }

    public Usuario(int id, String nickname, String nombre, String email, String psw, int id_bar) {
        this.id = id;
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.psw = psw;
        this.id_bar = id_bar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_bar() {
        return id_bar;
    }

    public void setId_bar(int id_bar) {
        this.id_bar = id_bar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "Usuario{}";
    }
}
