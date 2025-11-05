package org.proyecto.sav.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReservationDTO(
        Long id,

        @NotNull(message = "vehicleId es obligatorio")
        Long vehicleId,

        @NotNull(message = "startDate es obligatoria")
        @FutureOrPresent(message = "startDate no puede ser pasada")
        LocalDate startDate,

        @NotNull(message = "endDate es obligatoria")
        LocalDate endDate
) {}
