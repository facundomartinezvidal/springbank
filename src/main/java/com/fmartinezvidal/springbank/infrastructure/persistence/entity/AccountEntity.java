package com.fmartinezvidal.springbank.infrastructure.persistence.entity;

import com.fmartinezvidal.springbank.domain.model.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

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
    private ClientEntity client;
}
