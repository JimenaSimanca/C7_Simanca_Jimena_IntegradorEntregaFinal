package com.dh.Integrador.Repository;

import com.dh.Integrador.Models.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
