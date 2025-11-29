package org.proyecto.sav.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.ReservationDTO;
import org.proyecto.sav.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> list() {
        return ResponseEntity.ok(reservationService.list());
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> create(@RequestBody @Valid ReservationDTO dto) {
        return ResponseEntity.ok(reservationService.create(dto));
    }

    @PutMapping("/{reservationId}/payment/{paymentId}")
    public ResponseEntity<ReservationDTO> assignPayment(
            @PathVariable Long reservationId,
            @PathVariable Long paymentId) {
        return ResponseEntity.ok(reservationService.assignPayment(reservationId, paymentId));
    }

}
