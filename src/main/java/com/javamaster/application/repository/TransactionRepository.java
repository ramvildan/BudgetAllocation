package com.javamaster.application.repository;

import com.javamaster.application.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTransactionById(Integer id);
}
