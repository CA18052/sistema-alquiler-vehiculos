package org.proyecto.sav.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.CustomerDTO;
import org.proyecto.sav.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers") //ruta base para los endpoints de cliente
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    //Endpoint GET
    //devuelve la lista de todos los clientes registrados
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> list(){
        //llama al servicio para obtener los clientes y devuelve como repuesta HTTP 200 OK
        return ResponseEntity.ok(customerService.list());
    }

    //Endpoint POST
    //crea un nuevo cliente a partir de los datos recibidos en el cuerpo de la peticion
    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CustomerDTO dto) {
        //valida el DTO y lo envia al servicio para crear el cliente
        return ResponseEntity.ok(customerService.create(dto));
    }
}
