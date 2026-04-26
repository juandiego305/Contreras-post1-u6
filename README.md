# Laboratorio de Refactorización: De God Object a SRP (UFPS)

Este proyecto demuestra la transición de un diseño monolítico con antipatrones hacia una arquitectura limpia basada en el **Principio de Responsabilidad Única (SRP)**.

## ⚠️ Antipatrón Identificado: God Object
La clase inicial `GestorBiblioteca` funcionaba como un **Objeto Dios**, concentrando múltiples responsabilidades que hacían el código difícil de mantener y testear.

### Responsabilidades Identificadas:
1.  **Gestión del catálogo**: Registro y búsqueda de libros.
2.  **Gestión de socios**: Registro y validación de usuarios.
3.  **Gestión de préstamos**: Lógica de préstamo y devolución.
4.  **Generación de reportes**: Estadísticas del sistema.

## 🛠️ Refactorización Aplicada
Se descompuso el monolito en clases especializadas, utilizando **Inyección de Dependencias por Constructor** para mejorar el desacoplamiento:
- `Libro` y `Socio`: Clases de dominio (Entity) que reemplazan el uso de arrays de String.
- `CatalogoLibros`: Única fuente de verdad para el inventario.
- `RegistroSocios`: Encargada de la integridad de los datos de usuarios.
- `ServicioPrestamos`: Coordina la interacción entre libros y socios.
- `GeneradorReportes`: Componente exclusivo para la salida de información.

## 🚀 Cómo Ejecutar
1. Compilar el proyecto: `mvn clean compile`
2. Ejecutar la aplicación: `mvn exec:java` 

## 🧑‍💻 Autor
- **Juan Diego Contreras Garcia**
- **Ingeniería de Sistemas (UFPS) - 2026**
