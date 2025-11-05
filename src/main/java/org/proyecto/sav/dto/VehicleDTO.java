package org.proyecto.sav.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VehicleDTO(
        Long id,

        @NotBlank(message = "La placa es obligatoria")
        @Size(max = 20, message = "Placa muy larga")
        String plate,

        @NotBlank(message = "La marca es obligatoria")
        @Size(max = 50, message = "Marca muy larga")
        String brand,

        @NotBlank(message = "El modelo es obligatorio")
        @Size(max = 50, message = "Modelo muy largo")
        String model,

        @NotNull(message = "El estado es obligatorio")
        String status
) {}
