package org.proyecto.sav.service;

import lombok.RequiredArgsConstructor;
import org.proyecto.sav.dto.CustomerDTO;
import org.proyecto.sav.mapper.CustomerMapper;
import org.proyecto.sav.model.Customer;
import org.proyecto.sav.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    //lista todos los clientes registrados en la base de datos
    //convierte cada entidad Customer en un DTO para enviarlo al controlador

    @Transactional(readOnly = true)
    public List<CustomerDTO> list() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO) //convierte cada entidad a DTO
                .toList();
    }

    //crea un nuevo cliente si no existe previamente por email o licencia
    //convierte el DTO recibido en entidad, lo guarda, y devuelve el DTO resultante
    @Transactional
    public CustomerDTO create(CustomerDTO dto) {
        //validacion para no permitir datos duplicados
        if (customerRepository.existsByEmail(dto.email()) || customerRepository.existsByDriverLicense(dto.driverLicense())) {
            throw new IllegalArgumentException("El cliente ya existe");
        }

        //convertir el DTO a una entidad para guardarlo en la base de datos
        Customer entity = CustomerMapper.toEntity(dto);

        //guarda la entidad en la base de datos
        Customer saved = customerRepository.save(entity);

        //convertir la entidad guardada a DTO para devolverla al controlador
        return CustomerMapper.toDTO(saved);
    }
}
