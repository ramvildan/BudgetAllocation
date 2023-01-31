package com.javamaster.application.converter;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.dto.WalletDto;
import com.javamaster.application.entity.Users;
import com.javamaster.application.entity.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletsConverter {

    public Wallet fromWalletsDtoToWallet(WalletDto walletDto) {
        Wallet wallet = new Wallet();
        wallet.setId(walletDto.getId());
        wallet.setName(wallet.getName());
        wallet.setTransactions(wallet.getTransactions());
        return wallet;
    }

    public WalletDto fromWalletToWalletDto(Wallet wallet) {
        return WalletDto.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .transactions(wallet.getTransactions())
                .build();
    }
}