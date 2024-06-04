package com.solanaexchange.project.dao;

import com.solanaexchange.project.entity.CryptoBalances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CryptoBalancesRepo extends JpaRepository<CryptoBalances,Integer> {
    @Query(value = "SELECT * from crypto_balance where email = :email and wallet_type=:walletType", nativeQuery = true)
    List<CryptoBalances> findByEmailAndWallettype(String email, String walletType);
    @Query(value = "SELECT * from crypto_balance where email = :email and wallet_type=:walletType and currency=:currency", nativeQuery = true)
    CryptoBalances findByEmailAndWallettypeAndCurrency(String email, String walletType, String currency);


    @Query(value = "update crypto_balance set where email = :email and wallet_type=:walletType and currency=:currency", nativeQuery = true)
    CryptoBalances updateByEmailAndWallettypeAndCurrency(String email, String walletType, String currency);
}
