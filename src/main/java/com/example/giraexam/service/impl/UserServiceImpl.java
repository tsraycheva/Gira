package com.example.giraexam.service.impl;

import com.example.giraexam.model.entity.UserEntity;
import com.example.giraexam.model.service.UserServiceModel;
import com.example.giraexam.repository.UserRepository;
import com.example.giraexam.service.UserService;
import com.example.giraexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public UserServiceModel findUserByEmailAndPassword(String email, String password) {
        return userRepository
                        .findUserEntityByEmailAndPassword(email, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                        .orElse(null);
    }

    @Override
    public void loginUser(Long id, String email) {
        this.currentUser.setId(id)
                .setUsername(email)
                .setAnonymous(false);
    }

    @Override
    public UserEntity findUser() {
        return userRepository.findUserEntityById(currentUser.getId()).orElse(null);
    }
}
