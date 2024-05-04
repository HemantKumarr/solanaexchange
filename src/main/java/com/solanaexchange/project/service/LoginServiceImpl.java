package com.solanaexchange.project.service;

import com.solanaexchange.project.dao.UserRepository;
import com.solanaexchange.project.entity.Users;
import com.solanaexchange.project.model.UserRequestModel;
import com.solanaexchange.project.model.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseModel save(UserRequestModel userRequestModel) {
        String email = userRequestModel.getEmail();
        String password = userRequestModel.getPassword();

        Users user = new Users(email,password);
        UserResponseModel userResponseModel = new UserResponseModel();
        userResponseModel.setMessage("User created success");
        userResponseModel.setEmail(email);
        userRepository.save(user);
        return userResponseModel;
    }
}
