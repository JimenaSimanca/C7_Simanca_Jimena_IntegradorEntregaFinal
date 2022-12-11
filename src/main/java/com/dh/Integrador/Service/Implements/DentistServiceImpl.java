package com.dh.Integrador.Service.Implements;

import com.dh.Integrador.Models.Entities.Dentist;
import com.dh.Integrador.Repository.DentistRepository;
import com.dh.Integrador.Service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements IDentistService {
    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public List<Dentist> listDentist() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> searchDentist(Long id) {
        return dentistRepository.findById(id);
    }

    @Override
    public Dentist saveDentist(Dentist odontologo) {
        return dentistRepository.save(odontologo);
    }

    @Override
    public Dentist updateDentist(Dentist odontologo) {
        return dentistRepository.save(odontologo);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}
