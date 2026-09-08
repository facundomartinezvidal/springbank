package com.fmartinezvidal.springbank.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credit_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditTransactionEntity extends TransactionEntity {

    private int installments;
    private int currentInstallment;
    @ManyToOne
    private CardSummaryEntity cardSummary;
}
