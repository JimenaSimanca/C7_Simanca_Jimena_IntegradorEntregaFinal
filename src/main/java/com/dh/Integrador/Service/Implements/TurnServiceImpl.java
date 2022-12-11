package com.dh.Integrador.Service.Implements;

import com.dh.Integrador.Models.Entities.Turn;
import com.dh.Integrador.Repository.ITurnRepository;
import com.dh.Integrador.Service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnServiceImpl implements ITurnService {
    @Autowired
    private ITurnRepository turnRepository;

    @Override
    public Turn saveTurn(Turn turn){

        return turnRepository.save(turn);
    }

    @Override
    public List<Turn> listTurn() {

        return turnRepository.findAll();
    }

    @Override
    public Optional<Turn> searchTurnById(Long id) {

        return turnRepository.findById(id);
    }

    @Override
    public Turn updateTurn(Turn turno) {

        return turnRepository.save(turno);
    }

    @Override
    public void deleteTurn(Long id) {

        turnRepository.deleteById(id);
    }
}
