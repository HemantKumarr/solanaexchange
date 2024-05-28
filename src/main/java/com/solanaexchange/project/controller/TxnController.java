package com.solanaexchange.project.controller;

import com.solanaexchange.project.model.TransactionRequestModel;
import com.solanaexchange.project.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/user")
@RestController
public class TxnController {
    @Autowired
    TxnService txnService;
    @PostMapping("/txn")
    public Map<String,Object> performTxn(@RequestBody TransactionRequestModel transactionRequestModel){
        return txnService.performTxn(transactionRequestModel);
    }
}
