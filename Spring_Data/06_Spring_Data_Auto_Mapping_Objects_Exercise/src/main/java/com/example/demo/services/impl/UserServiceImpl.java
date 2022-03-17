package com.example.demo.services.impl;

import com.example.demo.entities.users.LoginDto;
import com.example.demo.entities.users.RegisterDto;
import com.example.demo.entities.users.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private User currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.currentUser = null;
    }

    @Override
    public User register(RegisterDto registerDto, ModelMapper modelMapper) {
        if (this.currentUser != null){
            //throw exception
        }
//        ModelMapper mapper = new ModelMapper();
        User toRegister = modelMapper.map(registerDto, User.class);

        long userCount = this.userRepository.count();
        if(userCount == 0){
            toRegister.setAdmin(true);
        }

        return this.userRepository.save(toRegister);
    }

    @Override
    public Optional<User> login(LoginDto loginData) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(loginData.getEmail(), loginData.getPassword());

        user.ifPresent(value -> this.currentUser = value);

        return user;
    }

    @Override
    public User getLoggedUser(){
        return this.currentUser;
    }

    @Override
    public void logout(){
        this.currentUser = null;
    }

}
