package org.proyecto.sav.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.VehicleDTO;
import org.proyecto.sav.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> list() {
        return ResponseEntity.ok(vehicleService.list());
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> create(@RequestBody @Valid VehicleDTO dto) {
        return ResponseEntity.ok(vehicleService.create(dto));
    }
}
