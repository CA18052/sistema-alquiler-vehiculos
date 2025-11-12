package org.proyecto.sav.repository;

import org.proyecto.sav.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //verica si ya extiste un cliente con ese email
    //el spring genera automaticamente la consulta basada en el nombre del metodo
    boolean existsByEmail(String email);

    //verica si ya extiste un cliente con esa licencia de conducir
    boolean existsByDriverLicense(String driverLicense);
}
