package com.dh.Integrador.Controller;
import com.dh.Integrador.Models.Entities.Patient;
import com.dh.Integrador.Exceptions.ResourceNotFoundException;
import com.dh.Integrador.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//usamos @Controller con vistas
@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private IPatientService IPatientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getPatient() {
        return ResponseEntity.ok(IPatientService.listPatient());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id){
        Optional<Patient> patientWanted= IPatientService.searchPatient(id);
        if(patientWanted.isPresent()){
            return ResponseEntity.ok(patientWanted.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping
    public ResponseEntity<Patient> registerNewPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(IPatientService.savePatient(patient));
    }
    @PutMapping
    public ResponseEntity<Patient> patientUpdate(@RequestBody Patient patient){
        Optional<Patient> patientToUpdate= IPatientService.searchPatient(patient.getId());
        if(patientToUpdate.isPresent()){
            return ResponseEntity.ok(IPatientService.updatePatient(patient));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) throws ResourceNotFoundException{
        Optional<Patient> patientToDelete= IPatientService.searchPatient(id);
        if (patientToDelete.isPresent()){
            IPatientService.deletePatient(id);
            return ResponseEntity.ok("Se eliminó al paciente con ID="+id);
        }
        else{
           throw new ResourceNotFoundException("!Error al eliminar¡ No se encontró al paciente con " +
                    "id="+id+". Error al ingresar el ID");

        }
    }

}
