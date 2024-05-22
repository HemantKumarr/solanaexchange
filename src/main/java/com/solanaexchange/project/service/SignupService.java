package com.solanaexchange.project.service;

import com.solanaexchange.project.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface SignupService {

    ResponseEntity addUser(UserRequestModel userRequestModel);
}
