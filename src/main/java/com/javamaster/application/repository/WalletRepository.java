package com.javamaster.application.repository;

import com.javamaster.application.entity.Users;
import com.javamaster.application.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Wallet findWalletById(Integer id);

    List<Wallet> findWalletByUserId(Integer userId);

    List<Wallet> findWalletByUserIdOrderByIdAsc(Integer userId);
}
