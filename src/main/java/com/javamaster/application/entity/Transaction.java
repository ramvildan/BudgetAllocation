package com.javamaster.application.entity;

import com.javamaster.application.entity.type.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "transaction_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "date")
    private Date createdAt;

    @Column(name = "status")
    private TransactionType type;

    @ManyToOne
    private Wallet wallet;
}
