package com.dh.Integrador.Service;

import com.dh.Integrador.Models.Entities.Dentist;

import java.util.List;
import java.util.Optional;

public interface IDentistService {
    List<Dentist> listDentist();
    Optional<Dentist> searchDentist(Long id);
    Dentist saveDentist(Dentist odontologo);
    Dentist updateDentist(Dentist odontologo);
    void deleteDentist(Long id);
}
