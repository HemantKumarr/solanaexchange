package com.solanaexchange.project.controller;

import com.solanaexchange.project.model.TxnHistEmail;
import com.solanaexchange.project.model.UserRequestModel;
import com.solanaexchange.project.service.SignupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins = "https://6670702b559a9b11e1947344--reliable-puppy-65afe5.netlify.app/")
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
        return signupService.getUser(userRequestModel);

    }

    @PostMapping("/loginHist")
    public ResponseEntity loginHistory(@RequestBody TxnHistEmail txnHistEmail){
        return signupService.getLoginHist(txnHistEmail);

    }
}