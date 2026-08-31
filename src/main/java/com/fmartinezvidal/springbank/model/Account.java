package com.fmartinezvidal.springbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(nullable = false)
    private BigDecimal balance;
    @Column(nullable = false)
    private String accountNumber;
    @ManyToOne
    private Client client;
}
