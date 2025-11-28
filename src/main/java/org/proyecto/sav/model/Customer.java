package org.proyecto.sav.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false, unique = true, length = 10)
    private String driverLicense;
}
