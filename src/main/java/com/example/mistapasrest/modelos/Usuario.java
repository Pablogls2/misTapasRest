package com.example.mistapasrest.modelos;

public class Usuario {

    private int id;
    private String email;
    private String psw;

    public Usuario(int id, String email, String psw) {
        this.id = id;
        this.email = email;
        this.psw = psw;
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
