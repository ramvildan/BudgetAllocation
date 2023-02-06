package com.javamaster.application.service.impl;

import com.javamaster.application.converter.TransactionsConverter;
import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.entity.Transaction;
import com.javamaster.application.entity.Wallet;
import com.javamaster.application.entity.type.TransactionType;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.repository.TransactionRepository;
import com.javamaster.application.repository.WalletRepository;
import com.javamaster.application.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    public void createIncomeTransaction(Integer userId, TransactionsDto transactionsDto) throws ValidationException {
        validationTransactionsDto(transactionsDto);
        List<Transaction> newTransaction =
                walletRepository.findWalletByUserId(userId).stream()
                        .map(wallet -> Transaction.builder()
                                .createdAt(new Date())
                                .type(TransactionType.INCOME)
                                .amount(transactionsDto.getAmount() * wallet.getSavePercent() / 100)
                                .wallet(wallet).build())
                        .toList();
        transactionRepository.saveAll(newTransaction);
    }

    @Override
    public void createExpenseTransaction(Integer walletId, TransactionsDto transactionsDto) throws ValidationException {
        validationTransactionsDto(transactionsDto);
        Wallet walletToUpdate = walletRepository.findWalletById(transactionsDto.getWalletId());
        Transaction newExpenseTransaction = Transaction.builder()
                .createdAt(new Date())
                .type(TransactionType.EXPENSE)
                .amount(transactionsDto.getAmount())
                .wallet(walletToUpdate)
                .build();
        transactionRepository.save(newExpenseTransaction);
    }

    @Override
    public List<TransactionsDto> getAllByUserId(Integer userId) {
        return walletRepository.findWalletByUserId(userId).stream()
                .map(Wallet::getTransactions)
                .flatMap(Collection::stream)
                .map(transactionsConverter::fromTransactionToTransactionDto)
                .toList();
    }

    @Override
    public List<TransactionsDto> getAllByWalletId(Integer walletId) {
        return transactionRepository.findTransactionByWalletId(walletId).stream()
                .map(transactionsConverter::fromTransactionToTransactionDto)
                .toList();
    }
}
