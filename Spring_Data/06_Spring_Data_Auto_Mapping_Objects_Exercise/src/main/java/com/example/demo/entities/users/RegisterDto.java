package com.example.demo.entities.users;

import com.example.demo.exceptions.ValidationException;


public class RegisterDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterDto(String[] commandParts){
        this.email = commandParts[1];
        this.password = commandParts[2];
        this.confirmPassword = commandParts[3];
        this.fullName = commandParts[4];

        this.validate();
    }

    private void validate() {
        int indexOfAt = email.indexOf("@");
        int indexOfDot = email.lastIndexOf(".");
        if(indexOfAt < 0 || indexOfDot < 0 || indexOfAt > indexOfDot){
            throw new ValidationException("Incorrect email.");
        }

        if(!validatePassword(password)){
            throw new ValidationException("Incorrect password.");
        }

        if(!password.equals(confirmPassword)){
            throw new ValidationException("Password and confirm password must match!");
        }
    }

    private boolean validatePassword(String password){
        boolean haveUpper = false;
        boolean haveLower = false;
        boolean haveDigit = false;

        char[] tokens = password.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            if(Character.isUpperCase(tokens[i])){
                haveUpper = true;
            }
            if(Character.isLowerCase(tokens[i])){
                haveLower = true;
            }
            if(Character.isDigit(tokens[i])){
                haveDigit = true;
            }
        }

        if (haveDigit && haveLower && haveUpper){
            return true;
        } else {
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }
}
