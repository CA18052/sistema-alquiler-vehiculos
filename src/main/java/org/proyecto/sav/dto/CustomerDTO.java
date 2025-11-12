package org.proyecto.sav.dto;

import jakarta.validation.constraints.*;

public record CustomerDTO(
        Long id,

        @NotBlank(message = "El nombre completo es requerido")
        String fullName,

        @Email(message = "Correo invalido")
        @NotBlank(message = "El correo es requerido")
        String email,

        @NotBlank(message = "El numero de telefono es requerido")
        String phone,

        @NotBlank(message = "La licencia de coducir es requerida")
        String driverLicense
) {}
