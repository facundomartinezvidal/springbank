package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class DebitTransaction extends Transaction {

    private final Long accountId;

    private DebitTransaction(Long id, String description, BigDecimal amount, LocalDateTime date, Long accountId) {
        super(id, description, amount, date, TransactionType.DEBIT);
        this.accountId = accountId;
    }

    public static DebitTransaction create(String description, BigDecimal amount, LocalDateTime date, Long accountId) {
        requireDescription(description);
        requireAmount(amount);
        requireDate(date);
        if (accountId == null) {
            throw new IllegalArgumentException("accountId es obligatorio");
        }
        return new DebitTransaction(null, description, amount, date, accountId);
    }

    public static DebitTransaction reconstitute(Long id, String description, BigDecimal amount,
                                                 LocalDateTime date, Long accountId) {
        return new DebitTransaction(id, description, amount, date, accountId);
    }

    public Long getAccountId() {
        return accountId;
    }
}
