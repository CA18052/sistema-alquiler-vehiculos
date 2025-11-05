package org.proyecto.sav.service;

import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.VehicleDTO;
import org.proyecto.sav.mapper.VehicleMapper;
import org.proyecto.sav.model.Vehicle;
import org.proyecto.sav.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<VehicleDTO> list() {
        return vehicleRepository.findAll().stream()
                .map(VehicleMapper::toDTO)
                .toList();
    }

    @Transactional
    public VehicleDTO create(VehicleDTO dto) {
        if (vehicleRepository.existsByPlate(dto.plate())) {
            throw new IllegalArgumentException("Ya existe un vehículo con esa placa");
        }
        Vehicle saved = vehicleRepository.save(VehicleMapper.toEntity(dto));
        return VehicleMapper.toDTO(saved);
    }

    @Transactional(readOnly = true)
    public Vehicle findByIdOrThrow(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));
    }
}
