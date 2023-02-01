package com.javamaster.application.repository;

import com.javamaster.application.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTransactionById(Integer id);

    List<Transaction> findTransactionByWalletId(Integer walletId);
}
