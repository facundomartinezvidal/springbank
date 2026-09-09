package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loan {

    private final Long id;
    private final BigDecimal interestRate;
    private final int installmentCount;
    private final BigDecimal amount;
    private final LocalDate startDate;
    private final Long clientId;

    private Loan(Long id, BigDecimal interestRate, int installmentCount, BigDecimal amount,
                 LocalDate startDate, Long clientId) {
        this.id = id;
        this.interestRate = interestRate;
        this.installmentCount = installmentCount;
        this.amount = amount;
        this.startDate = startDate;
        this.clientId = clientId;
    }

    public static Loan request(BigDecimal interestRate, int installmentCount, BigDecimal amount,
                                LocalDate startDate, Long clientId) {
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("interestRate invalida");
        }
        if (installmentCount < 1) {
            throw new IllegalArgumentException("installmentCount debe ser >= 1");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount debe ser positivo");
        }
        if (startDate == null) {
            throw new IllegalArgumentException("startDate es obligatoria");
        }
        if (clientId == null) {
            throw new IllegalArgumentException("clientId es obligatorio");
        }
        return new Loan(null, interestRate, installmentCount, amount, startDate, clientId);
    }

    public static Loan reconstitute(Long id, BigDecimal interestRate, int installmentCount, BigDecimal amount,
                                     LocalDate startDate, Long clientId) {
        return new Loan(id, interestRate, installmentCount, amount, startDate, clientId);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Long getClientId() {
        return clientId;
    }
}
