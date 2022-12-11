package com.dh.Integrador.Service;

import com.dh.Integrador.Models.Entities.Address;
import com.dh.Integrador.Models.Entities.Dentist;
import com.dh.Integrador.Models.Entities.Patient;
import com.dh.Integrador.Models.Entities.Turn;
import com.dh.Integrador.Service.Implements.DentistServiceImpl;
import com.dh.Integrador.Service.Implements.PatientServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnServiceImplTest {
    @Autowired
    ITurnService turnService;
    @Autowired
    PatientServiceImpl patientService;
    @Autowired
    DentistServiceImpl dentistService;


    @Test
    @Order(1)
    void saveTurnTest() {
        Address address = new Address("Cra", 81, "Bogotá", "Cundinamarca");
        Patient patient= new Patient("Calderón", "Edna", "ednac@mail.com", 53073, LocalDate.now(), address );
        Dentist dentist= new Dentist("Diana", "Rodríguez", "Matricula-15");

        Turn turn = new Turn(dentist, patient, LocalDate.now());

        patientService.savePatient(patient);
        dentistService.saveDentist(dentist);
        turnService.saveTurn(turn);
        Optional<Turn> recoveredTurn= turnService.searchTurnById(1l);
        assertTrue(recoveredTurn.isPresent());
    }

    @Test
    @Order(2)
    void listTurnTest() {
        List<Turn> listRecoveredTurn = turnService.listTurn();
        assertTrue(listRecoveredTurn.size()>0);
    }

    @Test
    @Order(3)
    void searchTurnByIdTest() {
        long searchTrunId = 1l;
        Optional<Turn> wantedTurn = turnService.searchTurnById(searchTrunId);
        assertTrue(wantedTurn.isPresent());
    }

    @Test
    @Order(4)
    void deleteTurnTest() {
        long idTurnToDelete = 1l;
        turnService.deleteTurn(idTurnToDelete);

        Optional<Turn> WantedTurnAfterDelete = turnService.searchTurnById(1l);
        assertFalse(WantedTurnAfterDelete.isPresent());
    }
}