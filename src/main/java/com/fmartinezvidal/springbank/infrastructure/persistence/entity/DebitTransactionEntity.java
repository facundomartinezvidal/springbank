package com.fmartinezvidal.springbank.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "debit_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebitTransactionEntity extends TransactionEntity {

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}
