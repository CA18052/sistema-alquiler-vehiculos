package org.proyecto.sav.mapper;

import org.proyecto.sav.dto.CustomerDTO;
import org.proyecto.sav.model.Customer;

public class CustomerMapper {

    //convierte una entidad Customer a un DTO
    public static CustomerDTO toDTO(Customer c) {
        return new CustomerDTO(
                c.getId(),
                c.getFullName(),
                c.getEmail(),
                c.getPhone(),
                c.getDriverLicense()
        );
    }

    //convierte un DTO a una entidad Customer
    public static Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.id())
                .fullName(dto.fullName())
                .email(dto.email())
                .phone(dto.phone())
                .driverLicense(dto.driverLicense())
                .build();
    }

}
