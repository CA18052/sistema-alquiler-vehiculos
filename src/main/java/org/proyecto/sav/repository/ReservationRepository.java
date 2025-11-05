package org.proyecto.sav.repository;

import org.proyecto.sav.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Para validar choques de fechas del mismo vehículo
    List<Reservation> findByVehicle_IdAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
            Long vehicleId, LocalDate start, LocalDate end
    );
}
