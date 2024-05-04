package com.solanaexchange.project.controller;

import com.solanaexchange.project.model.UserRequestModel;
import com.solanaexchange.project.model.UserResponseModel;
import com.solanaexchange.project.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/create")
@RestController
public class LoginController {

    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public UserResponseModel create(@RequestBody UserRequestModel userRequestModel){
        return loginService.save(userRequestModel);

    }
}
