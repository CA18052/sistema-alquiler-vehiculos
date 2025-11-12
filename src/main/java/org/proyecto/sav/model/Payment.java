package org.proyecto.sav.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "payments")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //metodo de pago (tarjeta, efectivo)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod method;

    //estado del pago (pendiente, aprobado)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    //monto pagado
    @Column(nullable = false)
    private BigDecimal amount;

    //moneda del pago
    @Column(nullable = false)
    private String currency;

    //fecha y hora del pago

    private OffsetDateTime date;

    //referencia del pago (numero de transaccion)
    @Column(nullable = false, unique = true)
    private String reference;

}
