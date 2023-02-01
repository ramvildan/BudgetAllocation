package com.javamaster.application.converter;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionsConverter {

    private final WalletsConverter walletsConverter;

    public Transaction fromTransactionsDtoToTransaction(TransactionsDto transactionsDto) {
        Transaction transaction = new Transaction();
        transaction.setId(transaction.getId());
        transaction.setAmount(transactionsDto.getAmount());
        transaction.setCreatedAt(transactionsDto.getCreatedAt());
        transaction.setWallet(walletsConverter.fromWalletsDtoToWallet(transactionsDto.getWalletDto()));
        return transaction;
    }

    public TransactionsDto fromTransactionToTransactionDto(Transaction transaction) {
        return TransactionsDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .walletDto(walletsConverter.fromWalletToWalletDto(transaction.getWallet()))
                .build();
    }
}
