package com.example.demo.services.impl;

import com.example.demo.entities.games.Game;
import com.example.demo.entities.games.GameAddDto;
import com.example.demo.entities.games.GameEditDto;
import com.example.demo.entities.users.LoginDto;
import com.example.demo.entities.users.RegisterDto;
import com.example.demo.entities.users.User;
import com.example.demo.services.ExecutorService;
import com.example.demo.services.GameService;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {
    private final UserService userService;
    private final GameService gameService;
    private ModelMapper modelMapper;

    @Autowired
    public ExecutorServiceImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public String execute(String commandLine) {

        String[] commandParts = commandLine.split("\\|");

        String commandName = commandParts[0];


        String commandOutput = switch (commandName) {
            case REGISTER_USER_COMMAND -> {
                RegisterDto registerData = new RegisterDto(commandParts);
                User user = userService.register(registerData, modelMapper);

                yield String.format("%s was registered", user.getFullName());
            }
            case LOGIN_USER_COMMAND -> {
                LoginDto loginData = new LoginDto(commandParts);
                Optional<User> user = userService.login(loginData);

                if (user.isPresent()) {
                    yield String.format("Successfully logged in %s", user.get().getFullName());
                } else {
                    yield "Incorrect username / password";
                }
            }
            case LOGOUT_USER_COMMAND -> {
                User loggedUser = this.userService.getLoggedUser();

                userService.logout();
                if (loggedUser == null) {
                    yield "Cannot log out. No user was logged in.";
                }
                yield String.format("User %s successfully logged out.", loggedUser.getFullName());
            }
            case ADD_GAME_COMMAND -> {
                User loggedUser = this.userService.getLoggedUser();

                if (loggedUser != null && loggedUser.isAdmin()) {
                    GameAddDto gameData = new GameAddDto(commandParts);
                    Game game = this.gameService.add(gameData, modelMapper);

                    yield String.format("Added %s", game.getTitle());
                } else {
                    yield "You aren't admin.";
                }
            }
            case EDIT_GAME_COMMAND -> {
                User loggedUser = this.userService.getLoggedUser();

                if (loggedUser != null && loggedUser.isAdmin()) {
                    int id = Integer.parseInt(commandParts[1]);
                    Game game = this.gameService.edit(id, commandParts);

                    if (game != null) {
                        yield String.format("Edited %s%n", game.getTitle());
                    } else {
                        yield "Wrong ID!";
                    }

                } else {
                    yield "You aren't admin.";
                }
            }
            case DELETE_GAME_COMMAND -> {
                User loggedUser = this.userService.getLoggedUser();

                if (loggedUser != null && loggedUser.isAdmin()) {
                    String result = this.gameService.delete(Integer.parseInt(commandParts[1]));
                    if (result.equals("null")) {
                        yield "Wrong ID!";
                    }
                    yield String.format("Deleted %s", result);
                } else {
                    yield "You aren't admin.";
                }
            }
            case ALL_GAMES -> {
                List<Game> allGames = this.gameService.findAll();

                StringBuilder sb = new StringBuilder();

                for (Game currGame : allGames) {
                    sb.append(String.format("%s %.2f%n",currGame.getTitle(), currGame.getPrice()));
                }

                yield sb.toString();
            }
            case DETAIL_GAME -> {
                Optional<Game> neededGame = this.gameService.findByTitle(commandParts[1]);
                if (neededGame.isPresent()){
                    yield String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s",
                            neededGame.get().getTitle(),
                            neededGame.get().getPrice(),
                            neededGame.get().getDescription(),
                            neededGame.get().getReleaseDate()
                    );
                }else {
                    yield "This game doesn't exist in DB";
                }
            }
            default -> "unknown command";
        };

        return commandOutput;


    }

}
