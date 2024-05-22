package com.solanaexchange.project.service;

import com.solanaexchange.project.dao.UserRepository;
import com.solanaexchange.project.dao.WalletRepo;
import com.solanaexchange.project.entity.Users;
import com.solanaexchange.project.entity.Wallet;
import com.solanaexchange.project.model.UserRequestModel;
import com.solanaexchange.project.model.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SignupServiceImpl implements SignupService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletRepo walletRepo;
    @Autowired
    WalletService walletService;
    private static final String FUND = "FUND";
    private static final String SPOT = "SPOT";

    @Override
    public ResponseEntity<?> addUser(UserRequestModel userRequestModel) {
        String email = userRequestModel.getEmail();
        String password = userRequestModel.getPassword();
        Map<String, Object> userBasicDetailMap = new LinkedHashMap<>();
        Optional<Users> userPresent = Optional.ofNullable(userRepository.findByEmail(userRequestModel.getEmail()));
        if(userPresent.isPresent()){
            userBasicDetailMap.put("status",0);
            userBasicDetailMap.put("message","User with this email ID already exists");
            return new ResponseEntity<>(userBasicDetailMap,HttpStatus.CONFLICT);
        }

        String userId = generateUserId(email);
        String referralCode = generateReferralCode();
        String fundWalletNumber = walletService.generateWalletNumbers(email).get(0);
        String spotWalletNumber = walletService.generateWalletNumbers(email).get(1);

        Users user = new Users(userId,email,password,referralCode,0,0);

        Wallet fundWallet = new Wallet(email,fundWalletNumber,FUND,"0",user);
        Wallet spotWallet = new Wallet(email,spotWalletNumber,SPOT,"0",user);

        List<Wallet> wallets = new ArrayList<>();
        wallets.add(fundWallet) ;
        wallets.add(spotWallet);
        walletRepo.save(fundWallet);
        walletRepo.save(spotWallet);
        user.setWallets(wallets);

        userRepository.save(user);
        userBasicDetailMap.put("status", 1);
        userBasicDetailMap.put("message", "User Created successfully");
        userBasicDetailMap.put("email", email);
        userBasicDetailMap.put("fundWalletNumber", fundWalletNumber);
        userBasicDetailMap.put("spotWalletNumber", spotWalletNumber);
        userBasicDetailMap.put("referralCode", referralCode);
        return new ResponseEntity(userBasicDetailMap, HttpStatus.OK);
    }

    private String generateUserId(String email) {
        int i = email.indexOf("@");
        String name = email.substring(0,i);
        Calendar c = Calendar.getInstance();
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String year = String.valueOf(c.get(Calendar.YEAR));
        String hour = String.valueOf(c.get(Calendar.HOUR));
        String min = String.valueOf(c.get(Calendar.MINUTE));
        String sec = String.valueOf(c.get(Calendar.SECOND));

        String sb = name + day+ month +year + hour+min+sec;
        return sb.toString();
    }

    private String generateReferralCode() {

        String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder random = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = (int) (ALPHANUMERIC.length() * Math.random());
            random.append(ALPHANUMERIC.charAt(index));
        }
        return random.toString();
    }
}
