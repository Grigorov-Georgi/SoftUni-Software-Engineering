package com.example.demo.services;

import com.example.demo.entities.users.LoginDto;
import com.example.demo.entities.users.RegisterDto;
import com.example.demo.entities.users.User;
import org.modelmapper.ModelMapper;

import java.util.Optional;


public interface UserService {
    User register(RegisterDto registerDto, ModelMapper modelMapper);

    Optional<User> login(LoginDto loginData);

    void logout();

    User getLoggedUser();
}
