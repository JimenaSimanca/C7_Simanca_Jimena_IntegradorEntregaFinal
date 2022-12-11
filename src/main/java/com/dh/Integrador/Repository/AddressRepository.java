package com.dh.Integrador.Repository;

import com.dh.Integrador.Models.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
