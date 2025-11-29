package org.proyecto.sav.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombreCompleto;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, unique = true, length = 10)
    private String licenciaConducir;
}
