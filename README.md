# 🚗 Sistema de Alquiler de Vehículos

API REST desarrollada con **Spring Boot 3** y **Java 17** para gestionar un sistema simple de alquiler:
- Vehículos (estado: DISPONIBLE, ALQUILADO, EN_MANTENIMIENTO)
- Reservas (rango de fechas, validaciones básicas)
- *Clientes y pagos están planificados para próximas entregas*

> **Entrega #2**: se incluye CRUD parcial para **vehículos** y **reservas**, uso de **DTOs**, **validaciones**, capa **service/repository**, **H2 en memoria**, y colección **Postman**.

---

## 🧰 Stack
- Java 17
- Spring Boot 3 (Web, Validation, Data JPA)
- H2 Database (en memoria para dev)
- Lombok
- Maven Wrapper

---

## ▶️ Cómo ejecutar (local)
Requisitos:
- JDK 17 instalado

Comandos:
```bash
# opción 1: desde IntelliJ, botón Run en SistemaDeAlquilerDeVehiculosApplication
# opción 2: por terminal
./mvnw spring-boot:run
