package com.example.demo.entities.users;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto(String[] commandLineParts){
        this.email = commandLineParts[1];
        this.password = commandLineParts[2];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
