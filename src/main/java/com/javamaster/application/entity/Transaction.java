package com.javamaster.application.entity;

import com.javamaster.application.entity.type.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "transaction_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date createdAt;

    @Column(name = "status")
    private TransactionType type;

    @ToString.Exclude
    @ManyToOne
    private Wallet wallet;
}
