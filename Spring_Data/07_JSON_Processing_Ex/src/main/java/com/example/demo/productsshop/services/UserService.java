package com.example.demo.productsshop.services;

import com.example.demo.productsshop.entities.users.UserWithSoldProductsDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductsDTO> getUsersWithSoldProducts();

}
