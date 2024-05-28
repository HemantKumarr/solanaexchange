package com.solanaexchange.project.model;

import lombok.Data;

@Data
public class TransactionRequestModel {
    private String amount;
    private String txnType;
    private String fromEmail;
    private String toEmail;
    private String currency;

}
