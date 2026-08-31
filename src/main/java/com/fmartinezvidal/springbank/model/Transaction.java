package com.fmartinezvidal.springbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String description;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}
