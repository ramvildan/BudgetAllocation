package com.javamaster.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsDto {

    private Integer id;
    private Double amount;
    private Date createdAt;
    private Integer walletId;

}
