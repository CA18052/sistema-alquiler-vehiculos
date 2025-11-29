package org.proyecto.sav.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Placa única para ubicar el carro rápidamente
    @Column(nullable = false, unique = true, length = 20)
    private String placa;

    // vin unico
    @Column(nullable = false, unique = true,length = 50)
    private String vin;

    @Column(nullable = false)
    private Long kilometraje;

    @Column(nullable = false, length = 50)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private VehicleStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_model_id", nullable = false)
    private VehicleModel vehicleModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
}
