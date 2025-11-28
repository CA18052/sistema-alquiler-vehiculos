package org.proyecto.sav.service;

import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.PaymentDTO;
import org.proyecto.sav.mapper.PaymentMapper;
import org.proyecto.sav.model.Payment;
import org.proyecto.sav.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//se encarga de listar y crear pagos
@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    //lista todos los pagos registrados en la base de datos
    //convierte cada entidad Payment en un DTO
    @Transactional(readOnly = true)
    public List<PaymentDTO> list(){
        return paymentRepository.findAll().stream()
                .map(PaymentMapper::toDTO)
                .toList();
    }

    //crea un nuevo pago a partir de los datos recibidos
    //convierte el DTO en entidad, lo guarda, y devuelve el DTO resultante
    @Transactional
    public PaymentDTO create(PaymentDTO dto) {
        Payment saved = paymentRepository.save(PaymentMapper.toEntity(dto));
        return PaymentMapper.toDTO(saved);
    }
}
