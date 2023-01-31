package com.javamaster.application.service.impl;

import com.javamaster.application.converter.WalletsConverter;
import com.javamaster.application.dto.WalletDto;
import com.javamaster.application.entity.Wallet;
import com.javamaster.application.repository.WalletRepository;
import com.javamaster.application.service.WalletsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultWalletsService implements WalletsService {

    private final WalletRepository walletRepository;

    private final WalletsConverter walletsConverter;

    @Override
    public WalletDto updateWalletName(Integer walletId, WalletDto walletDto) {
        Wallet walletToUpdate = walletRepository.findWalletById(walletId);
        walletToUpdate.setName(walletDto.getName());
        Wallet updatedWallet = walletRepository.save(walletToUpdate);
        return walletsConverter.fromWalletToWalletDto(updatedWallet);
    }

    @Override
    public WalletDto getById(Integer id) {
        return null;
    }

    @Override
    public List<WalletDto> getAllByUserId(Integer userId) {
        return null;
    }
}
