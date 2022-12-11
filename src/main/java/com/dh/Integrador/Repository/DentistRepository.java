package com.dh.Integrador.Repository;

import com.dh.Integrador.Models.Entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist,Long> {
}
