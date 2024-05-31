package com.solanaexchange.project.service;

import com.solanaexchange.project.dao.UserRepository;
import com.solanaexchange.project.entity.Users;
import com.solanaexchange.project.entity.Wallet;
import com.solanaexchange.project.model.UpdateEmail;
import com.solanaexchange.project.model.UpdatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SettingsService {

    @Autowired
    UserRepository userRepository;
    public String updateEmail(UpdateEmail updateEmail) {
        String email = updateEmail.getOldEmail();
        String password = updateEmail.getNewEmail();
        Map<String, Object> userBasicDetailMap = new LinkedHashMap<>();
        Optional<Users> userPresent = Optional.ofNullable(userRepository.findByEmail(updateEmail.getOldEmail()));
        if(userPresent.isEmpty()){
            userBasicDetailMap.put("status",0);
            userBasicDetailMap.put("message","User with this email ID does not exists");
            return userBasicDetailMap.toString();
        }
        Users u = userPresent.get();
        u.setEmail(updateEmail.getNewEmail());

        List<Wallet> wallet = u.getWallets();
        wallet.get(0).setEmail(updateEmail.getNewEmail());
        wallet.get(1).setEmail(updateEmail.getNewEmail());
        u.setWallets(wallet);
        userRepository.save(u);
        return "Email updated successfully - " ;
    }

    public String updatePassword(UpdatePassword updatePassword) {
        String email = updatePassword.getEmail();
        String oldPassword = updatePassword.getOldPassword();
        String newPassword = updatePassword.getNewPassword();
        Map<String, Object> userBasicDetailMap = new LinkedHashMap<>();
        Optional<Users> userPresent = Optional.ofNullable(userRepository.findByEmail(updatePassword.getEmail()));
        if(userPresent.isEmpty()){
            userBasicDetailMap.put("status",0);
            userBasicDetailMap.put("message","User with this email ID does not exists");
            return userBasicDetailMap.toString();
        }
        Users u = userPresent.get();
        if(!u.getPassword().equals(updatePassword.getOldPassword())){
            userBasicDetailMap.put("status",0);
            userBasicDetailMap.put("message","Password entered is incorrect");
            return userBasicDetailMap.toString();
        }

        u.setPassword(updatePassword.getNewPassword());

        userRepository.save(u);
//        u.getWallets().set(0,wallet.get(0).setEmail(updateEmail.getNewEmail()));
//        wallet.set(0,wallet.get(0).setEmail(updateEmail.getNewEmail()));
        return "Password updated successfully";
    }
}
