package com.javamaster.application.service;

import com.javamaster.application.dto.TransactionsDto;
import com.javamaster.application.exception.ValidationException;

import java.util.List;

public interface TransactionsService {

    TransactionsDto createTransaction(TransactionsDto transactionsDto) throws ValidationException;

    List<TransactionsDto> getAllByUserId(Integer userId);

    List<TransactionsDto> getAllByWalletId(Integer walletId);

}
