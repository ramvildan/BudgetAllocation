package com.javamaster.application.converter;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class TransactionsConverter {

    private final WalletsConverter walletsConverter;

    public Transaction fromTransactionsDtoToTransaction(TransactionsDto transactionsDto) {
        if (isNull(transactionsDto)) {
            return null;
        }
        return Transaction.builder()
                .id(transactionsDto.getId())
                .amount(transactionsDto.getAmount())
                .createdAt(transactionsDto.getCreatedAt())
                .wallet(walletsConverter.fromWalletsDtoToWallet(transactionsDto.getWalletDto()))
                .build();
    }

    public TransactionsDto fromTransactionToTransactionDto(Transaction transaction) {
        if (isNull(transaction)) {
            return null;
        }
        return TransactionsDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .walletDto(walletsConverter.fromWalletToWalletDto(transaction.getWallet()))
                .build();
    }
}
