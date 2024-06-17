package com.solanaexchange.project.controller;

import com.solanaexchange.project.model.UpdateEmail;
import com.solanaexchange.project.model.UpdatePassword;
import com.solanaexchange.project.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://6670702b559a9b11e1947344--reliable-puppy-65afe5.netlify.app/")
@RequestMapping("/settings")
public class SettingsController {
    @Autowired
    SettingsService settingsService;
    @PostMapping("/updateEmail")
    public String updateEmail(@RequestBody UpdateEmail updateEmail){
        return settingsService.updateEmail(updateEmail);
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@RequestBody UpdatePassword updatePassword){
        return settingsService.updatePassword(updatePassword);
    }
}
