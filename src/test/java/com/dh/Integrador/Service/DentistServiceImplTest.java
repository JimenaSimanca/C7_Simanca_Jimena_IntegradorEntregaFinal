package com.dh.Integrador.Service;

import com.dh.Integrador.Models.Entities.Dentist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class DentistServiceImplTest {
    @Autowired
    IDentistService dentistService;

    @Test
    @Order(1)
    public void addDentinstTest(){
        Dentist testDentist= new Dentist("Mathias","Simanca","218");
        dentistService.saveDentist(testDentist);
        Optional<Dentist> testRecoveredDentist= dentistService.searchDentist(1l);
        assertTrue(testRecoveredDentist.isPresent());
    }
    @Test
    @Order(2)
    public void searchDentistTest(){
        Long idWanted=1l;
        Optional<Dentist> recoveredDentist= dentistService.searchDentist(idWanted);
        assertTrue(recoveredDentist.isPresent());
    }
    @Test
    @Order(3)
    public void listDentistTest(){
        List<Dentist> testList= dentistService.listDentist();
        assertTrue(testList.size()>0);
    }
    @Test
    @Order(4)
    public void updateDentistTest(){
        Long idWanted=1l;
        Dentist updatedDentist=
                new Dentist(idWanted,"Antonio","Simanca","218");
        dentistService.updateDentist(updatedDentist);
        Optional<Dentist> recoveredDentist= dentistService.searchDentist(idWanted);
        assertEquals("Simanca",recoveredDentist.get().getApellido());
    }

    @Test
    @Order(5)
    void deleteDentistTest() {
        Long idToDetele=1l;
        dentistService.deleteDentist(idToDetele);
        Optional<Dentist> dentistToDelete = dentistService.searchDentist(idToDetele);
        System.out.println(dentistToDelete);
        assertTrue(dentistToDelete.isEmpty());
    }
}