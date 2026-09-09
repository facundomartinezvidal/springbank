package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CardSummary {

    private final Long id;
    private final LocalDate closeDate;
    private final LocalDate dueDate;
    private final BigDecimal totalAmount;
    private final BigDecimal minimumAmount;
    private final Long cardId;

    private CardSummary(Long id, LocalDate closeDate, LocalDate dueDate, BigDecimal totalAmount,
                         BigDecimal minimumAmount, Long cardId) {
        this.id = id;
        this.closeDate = closeDate;
        this.dueDate = dueDate;
        this.totalAmount = totalAmount;
        this.minimumAmount = minimumAmount;
        this.cardId = cardId;
    }

    public static CardSummary create(LocalDate closeDate, LocalDate dueDate, BigDecimal totalAmount,
                                      BigDecimal minimumAmount, Long cardId) {
        if (closeDate == null || dueDate == null) {
            throw new IllegalArgumentException("closeDate y dueDate son obligatorios");
        }
        if (closeDate.isAfter(dueDate)) {
            throw new IllegalArgumentException("closeDate no puede ser posterior a dueDate");
        }
        if (totalAmount == null || minimumAmount == null) {
            throw new IllegalArgumentException("totalAmount y minimumAmount son obligatorios");
        }
        if (minimumAmount.compareTo(totalAmount) > 0) {
            throw new IllegalArgumentException("minimumAmount no puede ser mayor a totalAmount");
        }
        if (cardId == null) {
            throw new IllegalArgumentException("cardId es obligatorio");
        }
        return new CardSummary(null, closeDate, dueDate, totalAmount, minimumAmount, cardId);
    }

    public static CardSummary reconstitute(Long id, LocalDate closeDate, LocalDate dueDate, BigDecimal totalAmount,
                                            BigDecimal minimumAmount, Long cardId) {
        return new CardSummary(id, closeDate, dueDate, totalAmount, minimumAmount, cardId);
    }

    public Long getId() {
        return id;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }

    public Long getCardId() {
        return cardId;
    }
}
