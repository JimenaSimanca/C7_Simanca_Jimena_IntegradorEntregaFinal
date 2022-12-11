package com.dh.Integrador.Service.Implements;

import com.dh.Integrador.Models.Entities.Patient;
import com.dh.Integrador.Repository.PatientRepository;
import com.dh.Integrador.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> listPatient() {

        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> searchPatient(Long id) {

        return patientRepository.findById(id);
    }

    @Override
    public Patient savePatient(Patient paciente) {

        return patientRepository.save(paciente);
    }

    @Override
    public Patient updatePatient(Patient paciente) {

        return patientRepository.save(paciente);
    }

    @Override
    public void deletePatient(Long id) {

        patientRepository.deleteById(id);
    }
}
