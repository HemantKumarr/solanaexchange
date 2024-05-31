package com.solanaexchange.project.controller;

import com.solanaexchange.project.model.TransactionP2PRequestModel;
import com.solanaexchange.project.model.TransactionRequestModel;
import com.solanaexchange.project.model.TxnHistEmail;
import com.solanaexchange.project.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/txn")
@RestController
public class TxnController {
    @Autowired
    TxnService txnService;
    @PostMapping("/interwallet")
    public Map<String,Object> performTxn(@RequestBody TransactionRequestModel transactionRequestModel){
        return txnService.performTxn(transactionRequestModel);
    }

    @PostMapping("/p2p")
    public Map<String,Object> performP2PTxn(@RequestBody TransactionP2PRequestModel transactionP2PRequestModel){
        return txnService.performP2PTxn(transactionP2PRequestModel);
    }

    @PostMapping("/interwallethist")
    public Map<String,Object> interwallethist(@RequestBody TxnHistEmail txnHistEmail){
        return txnService.interWalletHist(txnHistEmail);
    }
}
