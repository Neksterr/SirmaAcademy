package com.softuni.resellerApp.model;

import jakarta.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class UserRegisterBindingModel {

    @Length(min = 3, max = 20)
    private String username;

    @Email
    private String email;

    @Length(min = 3, max = 20)
    private String password;
    private String confirmPassword;

    public @Length(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@Length(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Length(min = 3, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@Length(min = 3, max = 20) String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
