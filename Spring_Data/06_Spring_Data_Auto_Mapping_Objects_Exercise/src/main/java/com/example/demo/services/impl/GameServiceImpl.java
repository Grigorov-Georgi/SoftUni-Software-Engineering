package com.example.demo.services.impl;

import com.example.demo.entities.games.Game;
import com.example.demo.entities.games.GameAddDto;
import com.example.demo.entities.games.GameEditDto;
import com.example.demo.entities.users.User;
import com.example.demo.repositories.GameRepository;
import com.example.demo.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game add(GameAddDto gameAddDto, ModelMapper modelMapper) {
        //it doesn't work for some reason
        //returns cannot parse thumbnailUrl to Integer
//        Game toAdd = modelMapper.map(gameAddDto, Game.class);
        //TODO: Validation for game fields must be made
        Game toAdd = new Game(gameAddDto.getTitle(), gameAddDto.getTrailerId(), gameAddDto.getThumbnailUrl(),
                gameAddDto.getSize(), gameAddDto.getPrice(), gameAddDto.getDescription(), gameAddDto.getReleaseDate());

        return this.gameRepository.save(toAdd);
    }

    @Override
    public Game edit(int id, String[] commandParts) {
        //TODO: <values> must be handled properly
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(commandParts[2].split("=")[1]));
        Float size = Float.parseFloat(commandParts[3].split("=")[1]);

        Optional<Game> byId = this.gameRepository.findById(id);

        if (byId.isPresent()){
            byId.get().setPrice(price);
            byId.get().setSize(size);
            this.gameRepository.save(byId.get());
            return byId.get();
        }
        return null;
    }

    @Override
    public String delete(int id) {
        if (this.gameRepository.findById(id).isPresent()) {
            Optional<Game> neededGame = this.gameRepository.findById(id);
            String neededTitle = "null";
            if (neededGame.isPresent()){
                neededTitle = neededGame.get().getTitle();
            }
            this.gameRepository.deleteById(id);
            return neededTitle;
        }
        return "null";
    }

    @Override
    public Optional<Game> findById(int id) {
        return this.gameRepository.findById(id);
    }

    @Override
    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Optional<Game> findByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }
}
