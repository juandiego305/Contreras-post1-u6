package com.universidad.antipatrones;
import java.util.*;

public class RegistroSocios {
    private final List<Socio> socios = new ArrayList<>();

    public void registrar(Socio socio) {
        if (!socio.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email invalido: " + socio.getEmail());
        }
        socios.add(socio);
        System.out.println("Socio registrado: " + socio.getNombre());
    }

    public boolean existe(String id) {
        return socios.stream().anyMatch(s -> s.getId().equals(id));
    }

    public int totalSocios() { return socios.size(); }
}