package com.javamaster.application.converter;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class TransactionsConverter {

    public TransactionsDto fromTransactionToTransactionDto(Transaction transaction) {
        if (isNull(transaction)) {
            return null;
        }
        return TransactionsDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .build();
    }
}
