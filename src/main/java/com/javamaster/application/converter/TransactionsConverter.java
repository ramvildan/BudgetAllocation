package com.javamaster.application.converter;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionsConverter {

    public Transaction fromTransactionsDtoToTransaction(TransactionsDto transactionsDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transaction.getId());
        transaction.setAmount(transactionsDto.getAmount());
        transaction.setCreatedAt(transactionsDto.getCreatedAt());
        transaction.setWallet(transactionsDto.getWallet());
        return transaction;
    }

    public TransactionsDto fromTransactionToTransactionDto(Transaction transaction) {
        return TransactionsDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .wallet(transaction.getWallet())
                .build();
    }
}
