package org.proyecto.sav.api;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.PaymentDTO;
import org.proyecto.sav.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//expone endpoints para listar y crear pagos
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

     //Endpoint GET
     //devuelve la lista de todos los pagos registrados
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> list() {
        return ResponseEntity.ok(paymentService.list());
    }

     //Endpoint POST
     //crea un nuevo pago a partir de los datos recibidos en el cuerpo de la peticion
    @PostMapping
    public ResponseEntity<PaymentDTO> create(@RequestBody @Valid PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.create(dto));
    }

}
