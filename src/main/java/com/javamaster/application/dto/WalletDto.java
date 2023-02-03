package com.javamaster.application.dto;

import com.javamaster.application.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {

    private Integer id;
    private String name;
    private Long amount;

}
