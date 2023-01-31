package com.javamaster.application.dto;

import com.javamaster.application.entity.Wallet;
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
    private Long amount;
    private Date createdAt;
    private Wallet wallet;

}
