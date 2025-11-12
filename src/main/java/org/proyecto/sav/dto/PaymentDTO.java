package org.proyecto.sav.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record PaymentDTO(
        Long id,

        @NotNull(message = "El metodo de pago es obligatorio")
        String method,

        @NotNull(message = "El estado del pago es obligatorio")
        String status,

        @NotNull(message = "El importe es obligatorio")
        BigDecimal amount,

        @NotBlank(message = "La moneda es obligatoria")
        String currency,

        //@NotNull(message = "La fecha es obligatoria")
        OffsetDateTime date,

        @NotBlank(message = "La referencia es obligatoria")
        String reference
) {}
