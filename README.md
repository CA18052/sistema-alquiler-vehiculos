# 🚗 Sistema de Alquiler de Vehículos (SAV)

Este proyecto es un sistema de gestión para el alquiler de vehículos.  
Permite administrar clientes, vehículos, alquileres y estados asociados.  
Está construido con **Spring Boot**, utilizando buenas prácticas de arquitectura y capas bien definidas.

---

## 📌 Características principales

- Gestión de vehículos (CRUD).
- Gestión de clientes.
- Gestión de alquileres.
- Uso de DTOs y mappers para separar la lógica de dominio.
- Arquitectura en capas: Controller → Service → Repository.
- Persistencia con Spring Data JPA.
- Pruebas unitarias con **JUnit 5** y **Mockito**.

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas:
- Controlador
- Servicio
- Entidad
- Repositorio

🚀 Cómo ejecutar el proyecto

--Clonar el repositorio

git clone https://github.com/usuario/sistema-alquiler-vehiculos.git
cd sistema-alquiler-vehiculo

--Ejecutar con Maven

mvn spring-boot:run

--Acceder a la aplicación

http://localhost:8080