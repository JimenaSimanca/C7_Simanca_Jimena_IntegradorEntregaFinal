package com.dh.Integrador.Service;

import com.dh.Integrador.Models.Entities.Address;
import com.dh.Integrador.Models.Entities.Patient;
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
public class PatientServiceImplTest {
    @Autowired
    IPatientService patientService;

    @Test
    @Order(1)
    public void addPatientTest(){
        Address addressTest = new Address("calle", 24, "Bogotá", "Cundinamarca");

        Patient patientTest= new Patient("Simanca", "Leonardo", "leo@mail.com", 1022388, LocalDate.now(), addressTest);
        patientService.savePatient(patientTest);
        Optional<Patient> recoveredPatient= patientService.searchPatient(1l);
        assertTrue(recoveredPatient.isPresent());
    }
    @Test
    @Order(2)
    public void searchPatientTest(){
        Long idWanted=1l;
        Optional<Patient> recoveredPatient= patientService.searchPatient(idWanted);
        assertTrue(recoveredPatient.isPresent());
    }

    @Test
    @Order(3)
    public void listPatientTest(){
        List<Patient> testList= patientService.listPatient();
        assertTrue(testList.size()>0);
    }

    @Test
    @Order(4)
    public void updatePatientTest(){
        Long idWanted=1l;
        Address newAddressTest = new Address("Cra", 40, "Bogotá", "Cundinamarca");
        Patient patientToUpdate = new Patient(idWanted,"Castro", "Leonardo", "leocastro@mail.com", 1022388, LocalDate.now(), newAddressTest);
        patientService.updatePatient(patientToUpdate);
        Optional<Patient> updatedPatientFound = patientService.searchPatient(idWanted);
        assertEquals("Castro",updatedPatientFound.get().getApellido());
    }

    @Test
    @Order(5)
    void deletePatientTest() {
        Long idToDelete=1l;
        patientService.deletePatient(idToDelete);
        Optional<Patient> patientToDelete = patientService.searchPatient(idToDelete);
        System.out.println(patientToDelete);
        assertTrue(patientToDelete.isEmpty());
    }
}