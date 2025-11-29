package org.proyecto.sav.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "vehicle_model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(nullable = false)
    private int anio;


}
