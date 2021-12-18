package com.example.giraexam.service;

import com.example.giraexam.model.entity.UserEntity;
import com.example.giraexam.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByEmailAndPassword(String email, String password);

    void loginUser(Long id, String username);

    UserEntity findUser();
}
