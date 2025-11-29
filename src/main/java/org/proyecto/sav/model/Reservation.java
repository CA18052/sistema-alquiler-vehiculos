package org.proyecto.sav.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "reservation")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String codigo;

    @Embedded
    private DateRange rango;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ReservationStatus status;

    @Column(length = 500)
    private String notas;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal importeReserva;

    @Column(precision = 12, scale = 2)
    private BigDecimal confirmar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Reservo un vehículo específico
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pickup_branch_id", nullable = false)
    private Branch pickupBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "return_branch_id")
    private Branch returnBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_plan_id")
    private InsurancePlan insurancePlan;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationExtra> extras;

}
