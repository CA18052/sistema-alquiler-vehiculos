package org.proyecto.sav.mapper;

import org.proyecto.sav.dto.PaymentDTO;
import org.proyecto.sav.model.Payment;
import org.proyecto.sav.model.PaymentMethod;
import org.proyecto.sav.model.PaymentStatus;

import java.time.OffsetDateTime;

public class PaymentMapper {
    //convierte una entidad Payment a un DTO
    public static PaymentDTO toDTO(Payment p) {
        return new PaymentDTO(
                p.getId(),
                p.getMethod().name(),
                p.getStatus().name(),
                p.getAmount(),
                p.getCurrency(),
                p.getDate(),
                p.getReference()
        );
    }

    //convierte un DTO a una entidad Payment
    public static Payment toEntity(PaymentDTO dto) {
        OffsetDateTime fechaPago = dto.date() != null ? dto.date() : OffsetDateTime.now();

        return Payment.builder()
                .id(dto.id())
                .method(PaymentMethod.valueOf(dto.method()))
                .status(PaymentStatus.valueOf(dto.status()))
                .amount(dto.amount())
                .currency(dto.currency())
                .date(fechaPago)
                .reference(dto.reference())
                .build();
    }

}
