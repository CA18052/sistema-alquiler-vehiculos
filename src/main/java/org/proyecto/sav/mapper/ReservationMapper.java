package org.proyecto.sav.mapper;

import org.proyecto.sav.dto.ReservationDTO;
import org.proyecto.sav.model.Reservation;
import org.proyecto.sav.model.Vehicle;

public class ReservationMapper {

    public static ReservationDTO toDTO(Reservation r) {
        return new ReservationDTO(
                r.getId(),
                r.getVehicle().getId(),
                r.getStartDate(),
                r.getEndDate(),
                r.getPayment() != null ? r.getPayment().getId() : null
        );
    }

    public static Reservation toEntity(ReservationDTO dto, Vehicle vehicle) {
        return Reservation.builder()
                .id(dto.id())
                .vehicle(vehicle)
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .build();
    }
}
