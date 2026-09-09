package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Installment {

    private final Long id;
    private final LocalDate dueDate;
    private final BigDecimal amount;
    private StatusInstallment status;
    private final Long loanId;

    private Installment(Long id, LocalDate dueDate, BigDecimal amount, StatusInstallment status, Long loanId) {
        this.id = id;
        this.dueDate = dueDate;
        this.amount = amount;
        this.status = status;
        this.loanId = loanId;
    }

    // toda cuota nueva arranca pendiente
    public static Installment schedule(LocalDate dueDate, BigDecimal amount, Long loanId) {
        if (dueDate == null) {
            throw new IllegalArgumentException("dueDate es obligatoria");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount debe ser positivo");
        }
        if (loanId == null) {
            throw new IllegalArgumentException("loanId es obligatorio");
        }
        return new Installment(null, dueDate, amount, StatusInstallment.PENDING, loanId);
    }

    public static Installment reconstitute(Long id, LocalDate dueDate, BigDecimal amount,
                                            StatusInstallment status, Long loanId) {
        return new Installment(id, dueDate, amount, status, loanId);
    }

    public void markAsPaid() {
        this.status = StatusInstallment.PAID;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public StatusInstallment getStatus() {
        return status;
    }

    public Long getLoanId() {
        return loanId;
    }
}
