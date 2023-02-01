package com.javamaster.application.service.impl;

import com.javamaster.application.converter.TransactionsConverter;
import com.javamaster.application.converter.UsersConverter;
import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.entity.Transaction;
import com.javamaster.application.entity.Wallet;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.repository.TransactionRepository;
import com.javamaster.application.repository.WalletRepository;
import com.javamaster.application.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class DefaultTransactionsService implements TransactionsService {

    private final TransactionRepository transactionRepository;

    private final WalletRepository walletRepository;

    private final TransactionsConverter transactionsConverter;

    private void validationTransactionsDto(TransactionsDto transactionsDto) throws ValidationException {
        if (isNull(transactionsDto)) {
            throw new ValidationException("Object transaction is null");
        }
        if (isNull(transactionsDto.getAmount()) || transactionsDto.getAmount() <= 0) {
            throw new ValidationException("Transaction is empty or 0");
        }
    }

    @Override
    public TransactionsDto createTransaction(TransactionsDto transactionsDto) throws ValidationException {
        validationTransactionsDto(transactionsDto);
        Transaction checkedTransaction = transactionRepository.save(transactionsConverter.fromTransactionsDtoToTransaction(transactionsDto));
        return transactionsConverter.fromTransactionToTransactionDto(checkedTransaction);
    }

    @Override
    public List<TransactionsDto> getAllByUserId(Integer userId) {
        return walletRepository.findWalletByUserId(userId).stream()
                .map(Wallet::getTransactions)
                .map(transactions -> getAllByUserId(userId))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionsDto> getAllByWalletId(Integer walletId) {
        return transactionRepository.findTransactionByWalletId(walletId)
                .stream()
                .map(transactionsConverter::fromTransactionToTransactionDto)
                .collect(Collectors.toList());
    }
}
