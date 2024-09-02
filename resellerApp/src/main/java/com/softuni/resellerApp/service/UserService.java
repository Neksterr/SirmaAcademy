package com.softuni.resellerApp.service;


import com.softuni.resellerApp.model.UserLoginBindingModel;
import com.softuni.resellerApp.model.UserRegisterBindingModel;
import com.softuni.resellerApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

}
