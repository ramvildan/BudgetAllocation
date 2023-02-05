package com.javamaster.application.converter;

import com.javamaster.application.dto.WalletDto;
import com.javamaster.application.entity.Wallet;
import com.javamaster.application.entity.type.TransactionType;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class WalletsConverter {

    public WalletDto fromWalletToWalletDto(Wallet wallet) {
        if (isNull(wallet)) {
            return null;
        }
        return WalletDto.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .amount(wallet.getTransactions().stream().mapToDouble(transaction -> {
                    if (transaction.getType().equals(TransactionType.INCOME)) {
                        return + transaction.getAmount();
                    } else {
                        return - transaction.getAmount();
                    }
                }).sum())
                .build();
    }
}
