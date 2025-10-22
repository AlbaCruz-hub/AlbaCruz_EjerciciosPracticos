package com.calidad.login.modelo;

public class Usuario {
private int id;
private String name;
private String email;

private String password;
private boolean isLogged;

    public boolean isLogged() {
    return isLogged;
}
    public Usuario(String email, boolean isLogged, String name, String password) {
        this.email = email;
        this.isLogged = isLogged;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isIsLogged() {
        return isLogged;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
}