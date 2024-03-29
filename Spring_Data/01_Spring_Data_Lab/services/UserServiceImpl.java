package com.example._11_spring_data_lab.services;

import com.example._11_spring_data_lab.models.User;
import com.example._11_spring_data_lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        User fount = this.userRepository.findByUsername(user.getUsername());

        if (fount == null) {
            this.userRepository.save(user);
        }
    }
}
