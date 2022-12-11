package com.dh.Integrador.Service;

import com.dh.Integrador.Models.Entities.Turn;

import java.util.List;
import java.util.Optional;

public interface ITurnService {

    Turn saveTurn(Turn turno);
    List<Turn> listTurn();
    Optional<Turn> searchTurnById(Long id);
    Turn updateTurn(Turn turno);
    void deleteTurn(Long id);

}
