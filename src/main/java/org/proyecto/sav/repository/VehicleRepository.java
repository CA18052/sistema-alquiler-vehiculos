package org.proyecto.sav.repository;

import org.proyecto.sav.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByPlate(String plate);
    boolean existsByPlate(String plate);
}
