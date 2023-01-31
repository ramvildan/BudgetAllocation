package com.javamaster.application.repository;

import com.javamaster.application.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Wallet findWalletById(Integer id);
}
