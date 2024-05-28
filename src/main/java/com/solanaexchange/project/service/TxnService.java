package com.solanaexchange.project.service;

import com.solanaexchange.project.model.TransactionRequestModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TxnService {

    public Map<String,Object> performTxn(TransactionRequestModel transactionRequestModel){
        String amt = transactionRequestModel.getAmount();
        String sender = transactionRequestModel.getFromEmail();
        String receiver = transactionRequestModel.getToEmail();
        Map<String,Object> map = new HashMap<>();
        return map;
    }

}
