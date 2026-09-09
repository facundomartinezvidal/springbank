package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public sealed abstract class Transaction permits DebitTransaction, CreditTransaction {

    private final Long id;
    private final String description;
    private final BigDecimal amount;
    private final LocalDateTime date;
    private final TransactionType transactionType;

    protected Transaction(Long id, String description, BigDecimal amount, LocalDateTime date,
                           TransactionType transactionType) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.transactionType = transactionType;
    }

    protected static void requireDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description es obligatoria");
        }
    }

    protected static void requireAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount debe ser positivo");
        }
    }

    protected static void requireDate(LocalDateTime date) {
        if (date == null) {
            throw new IllegalArgumentException("date es obligatoria");
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
