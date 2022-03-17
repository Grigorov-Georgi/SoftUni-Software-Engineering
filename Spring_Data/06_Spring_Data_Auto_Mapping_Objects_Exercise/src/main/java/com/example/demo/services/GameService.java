package com.example.demo.services;

import com.example.demo.entities.games.Game;
import com.example.demo.entities.games.GameAddDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public interface GameService {
    Game add(GameAddDto gameAddDto, ModelMapper modelMapper);
    Game edit(int id, String[] commandParts);
    String delete(int id);

    Optional<Game> findById(int id);

    List<Game> findAll();

    Optional<Game> findByTitle(String title);
}
