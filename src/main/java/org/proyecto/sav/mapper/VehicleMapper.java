package org.proyecto.sav.mapper;

import org.proyecto.sav.dto.VehicleDTO;
import org.proyecto.sav.model.Vehicle;
import org.proyecto.sav.model.VehicleStatus;

public class VehicleMapper {

    public static VehicleDTO toDTO(Vehicle v) {
        return new VehicleDTO(
                v.getId(),
                v.getPlate(),
                v.getBrand(),
                v.getModel(),
                v.getStatus().name()
        );
    }

    public static Vehicle toEntity(VehicleDTO dto) {
        return Vehicle.builder()
                .id(dto.id())
                .plate(dto.plate())
                .brand(dto.brand())
                .model(dto.model())
                .status(VehicleStatus.valueOf(dto.status()))
                .build();
    }
}
