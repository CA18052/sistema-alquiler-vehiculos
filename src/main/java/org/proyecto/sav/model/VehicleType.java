package org.proyecto.sav.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "vehicle_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false, length = 30)
    private String transmision;


}
