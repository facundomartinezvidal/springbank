package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class CreditTransaction extends Transaction {

    private final int installmentCount;
    private final int currentInstallment;
    private final Long cardSummaryId;

    private CreditTransaction(Long id, String description, BigDecimal amount, LocalDateTime date,
                               int installmentCount, int currentInstallment, Long cardSummaryId) {
        super(id, description, amount, date, TransactionType.CREDIT);
        this.installmentCount = installmentCount;
        this.currentInstallment = currentInstallment;
        this.cardSummaryId = cardSummaryId;
    }

    public static CreditTransaction create(String description, BigDecimal amount, LocalDateTime date,
                                            int installmentCount, int currentInstallment, Long cardSummaryId) {
        requireDescription(description);
        requireAmount(amount);
        requireDate(date);
        if (installmentCount < 1) {
            throw new IllegalArgumentException("installmentCount debe ser >= 1");
        }
        if (currentInstallment < 1 || currentInstallment > installmentCount) {
            throw new IllegalArgumentException("currentInstallment fuera de rango");
        }
        if (cardSummaryId == null) {
            throw new IllegalArgumentException("cardSummaryId es obligatorio");
        }
        return new CreditTransaction(null, description, amount, date, installmentCount, currentInstallment, cardSummaryId);
    }

    public static CreditTransaction reconstitute(Long id, String description, BigDecimal amount, LocalDateTime date,
                                                  int installmentCount, int currentInstallment, Long cardSummaryId) {
        return new CreditTransaction(id, description, amount, date, installmentCount, currentInstallment, cardSummaryId);
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public int getCurrentInstallment() {
        return currentInstallment;
    }

    public Long getCardSummaryId() {
        return cardSummaryId;
    }
}
