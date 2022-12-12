package com.dh.Integrador.Controller;

import com.dh.Integrador.Models.Entities.Dentist;
import com.dh.Integrador.Exceptions.ResourceNotFoundException;
import com.dh.Integrador.Service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentists")
public class DentistController {
    @Autowired
    private IDentistService dentistService;

    @GetMapping
    public ResponseEntity<List<Dentist>> dentistList() {

        return ResponseEntity.ok(dentistService.listDentist());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dentist> dentistListById(@PathVariable("id") Long id){
        Optional<Dentist> dentistWanted= dentistService.searchDentist(id);
        return dentistWanted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping("")
    public ResponseEntity<Dentist> registerNewDentist(@Valid @RequestBody Dentist dentist){
        return ResponseEntity.ok(dentistService.saveDentist(dentist));
    }
    @PutMapping
    public ResponseEntity<Dentist> updateDentist(@RequestBody Dentist dentist){
        Optional<Dentist> dentistToUpdate= dentistService.searchDentist(dentist.getId());
        if(dentistToUpdate.isPresent()){
            return ResponseEntity.ok(dentistService.updateDentist(dentist));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Dentist> dentistToDelete= dentistService.searchDentist(id);
        if (dentistToDelete.isPresent()){
            dentistService.deleteDentist(id);
            return ResponseEntity.ok("Se eliminó al odontólogo con ID="+id);
        }
        else{
            throw new ResourceNotFoundException("!Error al eliminar¡ No se encontró al odontólogo con " +
                    "id="+id+". Error al ingresar el ID");
        }
    }
}
