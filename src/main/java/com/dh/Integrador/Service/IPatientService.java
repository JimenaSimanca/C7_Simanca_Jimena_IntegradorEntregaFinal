package com.dh.Integrador.Service;

import com.dh.Integrador.Models.Entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService {
    List<Patient> listPatient();
    Optional<Patient> searchPatient(Long id);
    Patient savePatient(Patient paciente);
    Patient updatePatient(Patient paciente);
    void deletePatient(Long id);
}
