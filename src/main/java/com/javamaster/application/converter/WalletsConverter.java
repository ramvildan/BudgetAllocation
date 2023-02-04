package com.javamaster.application.converter;

import com.javamaster.application.dto.WalletDto;
import com.javamaster.application.entity.Transaction;
import com.javamaster.application.entity.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class WalletsConverter {

    public Wallet fromWalletsDtoToWallet(WalletDto walletDto) {
        if (isNull(walletDto)) {
            return null;
        }
        return Wallet.builder()
                .id(walletDto.getId())
                .name(walletDto.getName())
                .build();
    }

    public WalletDto fromWalletToWalletDto(Wallet wallet) {
        if (isNull(wallet)) {
            return null;
        }
        return WalletDto.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .amount(wallet.getTransactions().stream().mapToLong(Transaction::getAmount).sum())
                .build();
    }
}
