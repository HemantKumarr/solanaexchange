package com.solanaexchange.project.service;

import com.solanaexchange.project.dao.TxnInterWalletRepo;
import com.solanaexchange.project.dao.WalletRepo;
import com.solanaexchange.project.entity.TxnInterWallet;
import com.solanaexchange.project.entity.Wallet;
import com.solanaexchange.project.model.TransactionP2PRequestModel;
import com.solanaexchange.project.model.TransactionRequestModel;
import com.solanaexchange.project.model.TxnHistEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TxnService {

    @Autowired
    WalletRepo walletRepo;
    @Autowired
    TxnInterWalletRepo txnInterWalletRepo;
    public Map<String,Object> performTxn(TransactionRequestModel transactionRequestModel){
        int amt = Integer.parseInt(transactionRequestModel.getAmount());
        String sender = transactionRequestModel.getFromWalletType();
        String receiver = transactionRequestModel.getToWalletType();
        Map<String,Object> map = new HashMap<>();
        Optional<List<Wallet>> walletList = Optional.ofNullable(walletRepo.findByEmail(transactionRequestModel.getEmail()));
        if(walletList.isEmpty()){
            map.put("status","0");
            map.put("message","No wallet found for the email id");
            return map;
        }
        List<Wallet> w = walletList.get();
        Wallet fundWallet = w.get(0);
        Wallet spotWallet = w.get(1);
        Integer fundWalletBal=0, spotWalletBal=0;
        if(Integer.parseInt(fundWallet.getWalletBalance())<amt){
            map.put("status","0");
            map.put("message","Not enough balance to perform this transaction");
            return map;
        }
        if(transactionRequestModel.getFromWalletType().equals("FUND") && transactionRequestModel.getToWalletType().equals("SPOT") ){
            if(Integer.parseInt(fundWallet.getWalletBalance())<amt){
                map.put("status","0");
                map.put("message","Not enough balance to perform this transaction");
                return map;
            }
             fundWalletBal = Integer.parseInt(fundWallet.getWalletBalance())- amt;
             spotWalletBal = Integer.parseInt(spotWallet.getWalletBalance())+ amt;
        }
        if(transactionRequestModel.getFromWalletType().equals("SPOT") && transactionRequestModel.getToWalletType().equals("FUND")){
            if(Integer.parseInt(spotWallet.getWalletBalance())<amt){
                map.put("status","0");
                map.put("message","Not enough balance to perform this transaction");
                return map;
            }
             fundWalletBal = Integer.parseInt(fundWallet.getWalletBalance()) + amt;
             spotWalletBal = Integer.parseInt(spotWallet.getWalletBalance()) - amt;
        }
        fundWallet.setWalletBalance(fundWalletBal.toString());
        spotWallet.setWalletBalance(spotWalletBal.toString());

        walletRepo.save(fundWallet);
        walletRepo.save(spotWallet);
        TxnInterWallet txnInterWallet = new TxnInterWallet(transactionRequestModel.getEmail(),transactionRequestModel.getAmount(),transactionRequestModel.getFromWalletType(),transactionRequestModel.getToWalletType(),transactionRequestModel.getCurrency());
        txnInterWalletRepo.save(txnInterWallet);
        map.put("txnDetails",txnInterWallet);
                return map;
    }

    public Map<String, Object> performP2PTxn(TransactionP2PRequestModel transactionP2PRequestModel) {
        int amt = Integer.parseInt(transactionP2PRequestModel.getAmount());
        String sender = transactionP2PRequestModel.getFromEmail();
        String receiver = transactionP2PRequestModel.getToEmail();
        Map<String,Object> map = new HashMap<>();
        Optional<List<Wallet>> walletList = Optional.ofNullable(walletRepo.findByEmail(transactionP2PRequestModel.getFromEmail()));
        return map;

    }

    public Map<String, Object> interWalletHist(TxnHistEmail txnHistEmail) {
        String email = txnHistEmail.getEmail();
        Map<String,Object> map = new HashMap<>();
        Optional<List<TxnInterWallet>> txnInterWalletList = Optional.ofNullable(txnInterWalletRepo.findByEmail(email));
        if(txnInterWalletList.isEmpty()){
            map.put("status","0");
            map.put("message","NO transactions found");
        }
        map.put("status","1");
        map.put("txns",txnInterWalletList);
        return map;

    }

}
