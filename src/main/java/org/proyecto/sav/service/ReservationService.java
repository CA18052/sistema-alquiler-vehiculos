package org.proyecto.sav.service;

import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.ReservationDTO;
import org.proyecto.sav.mapper.ReservationMapper;
import org.proyecto.sav.model.Reservation;
import org.proyecto.sav.model.Vehicle;
import org.proyecto.sav.model.VehicleStatus;
import org.proyecto.sav.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final VehicleService vehicleService;

    @Transactional(readOnly = true)
    public List<ReservationDTO> list() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDTO)
                .toList();
    }

    @Transactional
    public ReservationDTO create(ReservationDTO dto) {
        if (dto.endDate().isBefore(dto.startDate())) {
            throw new IllegalArgumentException("Rango de fechas inválido");
        }

        Vehicle vehicle = vehicleService.findByIdOrThrow(dto.vehicleId());
        if (vehicle.getStatus() != VehicleStatus.DISPONIBLE) {
            throw new IllegalStateException("El vehículo no está disponible");
        }

        // Validar choques de fechas para ese vehículo
        List<Reservation> overlaps = reservationRepository
                .findByVehicle_IdAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
                        vehicle.getId(), dto.startDate(), dto.endDate()
                );

        if (!overlaps.isEmpty()) {
            throw new IllegalStateException("Fechas no disponibles para este vehículo");
        }

        Reservation saved = reservationRepository.save(
                ReservationMapper.toEntity(dto, vehicle)
        );
        return ReservationMapper.toDTO(saved);
    }
}
