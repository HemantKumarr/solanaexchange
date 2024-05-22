package com.solanaexchange.project.controller;

import com.solanaexchange.project.model.UserRequestModel;
import com.solanaexchange.project.service.SignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class LoginController {

    SignupService signupService;

    public LoginController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody UserRequestModel userRequestModel){
        return signupService.addUser(userRequestModel);

    }

    @PostMapping("/login")
    public ResponseEntity fetchUser(@RequestBody UserRequestModel userRequestModel){
        return signupService.addUser(userRequestModel);

    }
}
