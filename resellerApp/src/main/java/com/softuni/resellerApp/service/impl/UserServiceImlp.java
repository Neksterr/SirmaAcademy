package com.softuni.resellerApp.service.impl;

import com.softuni.resellerApp.model.UserLoginBindingModel;
import com.softuni.resellerApp.model.UserRegisterBindingModel;
import com.softuni.resellerApp.model.entity.User;
import com.softuni.resellerApp.repository.UserRepository;
import com.softuni.resellerApp.service.LoggedUser;
import com.softuni.resellerApp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImlp implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;
    public UserServiceImlp(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if(userRegisterBindingModel == null){
            return false;
        }

        String username = userRegisterBindingModel.getUsername();
       if( this.userRepository.findByUsername(username) != null){
           return false;
       }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setEmail(userRegisterBindingModel.getEmail());
        this.userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        User user = findUserByUsername(userLoginBindingModel.getUsername());
        if(user != null && passwordEncoder.matches( userLoginBindingModel.getPassword(),user.getPassword())){
        loggedUser.setUsername(user.getUsername());
        loggedUser.setLogged(true);
        return true;

        }
        return false;
    }
    private User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
