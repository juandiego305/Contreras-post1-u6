package com.universidad.antipatrones;

public class Socio {
    private final String id, nombre, email;

    public Socio(String id, String nombre, String email) {
        this.id = id; this.nombre = nombre; this.email = email;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}