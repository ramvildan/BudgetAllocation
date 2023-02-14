package com.javamaster.application.service;

import com.javamaster.application.dto.WalletDto;

import java.util.List;

public interface WalletsService {

    WalletDto updateWalletName(Integer walletId, WalletDto walletDto);

    WalletDto getById(Integer id);

    List<WalletDto> getAllByUserId(Integer userId);
}
