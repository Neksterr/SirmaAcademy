package com.softuni.resellerApp.model;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {

    @Length(min=3, max= 20)
    private String username;
    @Length(min=3, max= 20)
    private String password;

    public @Length(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@Length(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @Length(min = 3, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@Length(min = 3, max = 20) String password) {
        this.password = password;
    }
}
