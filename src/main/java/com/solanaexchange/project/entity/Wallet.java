package com.solanaexchange.project.entity;

import jakarta.persistence.*;

@Entity
@Table(name="WALLET")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WALLET_ID")
    private String id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="WALLET_NUMBER")
    private String walletNumber;

    @Column(name="WALLET_TYPE")
    private String walletTYPE;

    @Column(name="WALLET_BALANCE")
    private String walletBalance;

    @ManyToOne
    private Users user;
    public Wallet() {
    }

    public Wallet(String email, String walletNumber, String walletTYPE, String walletBalance, Users user) {
        this.email = email;
        this.walletNumber = walletNumber;
        this.walletTYPE = walletTYPE;
        this.walletBalance = walletBalance;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWalletNumber() {
        return walletNumber;
    }

    public void setWalletNumber(String walletNumber) {
        this.walletNumber = walletNumber;
    }

    public String getWalletTYPE() {
        return walletTYPE;
    }

    public void setWalletTYPE(String walletTYPE) {
        this.walletTYPE = walletTYPE;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", walletNumber='" + walletNumber + '\'' +
                ", walletTYPE='" + walletTYPE + '\'' +
                ", walletBalance='" + walletBalance + '\'' +
                '}';
    }
}
