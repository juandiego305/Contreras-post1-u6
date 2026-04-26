package com.universidad.antipatrones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// GOD OBJECT: Clase que concentra todas las responsabilidades [cite: 453-454]
public class GestorBiblioteca {
    
    // Datos mezclados de 3 dominios [cite: 455-463]
    private List<String[]> libros = new ArrayList<>(); 
    private List<String[]> socios = new ArrayList<>(); 
    private List<String[]> prestamos = new ArrayList<>();

    // Responsabilidad 1: Gestión de libros [cite: 465-477]
    public void agregarLibro(String id, String titulo, String autor) {
        libros.add(new String[] {id, titulo, autor, "true"});
        System.out.println("Libro agregado: " + titulo);
    }

    public Optional<String[]> buscarLibro(String id) {
        return libros.stream().filter(l -> l[0].equals(id)).findFirst();
    }

    // Responsabilidad 2: Gestión de socios [cite: 479-490]
    public void registrarSocio(String id, String nombre, String email) {
        if (!email.contains("@")) {
            System.out.println("Email invalido");
            return;
        }
        socios.add(new String[] {id, nombre, email});
        System.out.println("Socio registrado: " + nombre);
    }

    // Responsabilidad 3: Gestión de préstamos [cite: 491-514]
    public void realizarPrestamo(String libroId, String socioId) {
        Optional<String[]> libro = buscarLibro(libroId);
        if (libro.isPresent()) {
            libro.get()[3] = "false"; // Marcamos como no disponible
            prestamos.add(new String[] {libroId, socioId, "2026-03-17"});
            System.out.println("Prestamo realizado: libro " + libroId + " a socio " + socioId);
        }
    }

    // Responsabilidad 4: Reportes [cite: 516-525]
    public void imprimirReporteCompleto() {
        System.out.println("=== REPORTE BIBLIOTECA ===");
        System.out.println("Libros registrados: " + libros.size());
        System.out.println("Socios registrados: " + socios.size());
        System.out.println("Prestamos activos: " + prestamos.size());
        System.out.println("==========================");
    }
}