package com.dh.Integrador.Controller;

import com.dh.Integrador.Models.Entities.Turn;
import com.dh.Integrador.Exceptions.BadRequestException;
import com.dh.Integrador.Exceptions.ResourceNotFoundException;
import com.dh.Integrador.Service.ITurnService;
import com.dh.Integrador.Service.IDentistService;
import com.dh.Integrador.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turns")
public class TurnController {

    private ITurnService turnService;
    private IDentistService dentistService;
    private IPatientService IPatientService;

    @Autowired
    public TurnController(ITurnService turnService, IDentistService dentistService, IPatientService IPatientService) {
        this.turnService = turnService;
        this.dentistService = dentistService;
        this.IPatientService = IPatientService;
    }

    @GetMapping
    public ResponseEntity<List<Turn>> viewTurn(){
        if (turnService.listTurn().isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(turnService.listTurn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turn> searchTurnById(@PathVariable Long id){
        Optional<Turn> wantedTurn= turnService.searchTurnById(id);
        if (wantedTurn.isPresent()){
            return ResponseEntity.ok(wantedTurn.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Turn> registerNewTurn(@RequestBody Turn turn) throws BadRequestException {
        Long patientId = turn.getPatient().getId();
        Long dentistId = turn.getDentist().getId();

        if (IPatientService.searchPatient(patientId).isEmpty()){
            throw new BadRequestException("!Error al agregar turno¡ El paciente con ID "+ patientId +" no existe, favor crearlo");
        } else if (dentistService.searchDentist(dentistId).isEmpty()) {
            throw new BadRequestException("!Error al agregar turno¡ El odontologo con ID "+ dentistId +" no existe, favor crearlo");
        } else {
            return ResponseEntity.ok(turnService.saveTurn(turn));
        }
    }

    @PutMapping
    public ResponseEntity<Turn> modifyTurn(@RequestBody Turn turn){
        Optional<Turn> turnToUpdate= turnService.searchTurnById(turn.getId());
        if (turnToUpdate.isPresent()){
            return ResponseEntity.ok(turnService.updateTurn(turn));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurn(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Turn> turnToDelete= turnService.searchTurnById(id);
        if (turnToDelete.isPresent()){
            turnService.deleteTurn(id);
            return ResponseEntity.ok("Se eliminó el turno con id= "+id+" de la base de datos");
        }
        else{
            throw new ResourceNotFoundException("!Error¡ No se pudo eliminar el turno con id "+ id+", Turno no encontrado");
        }
    }

}
