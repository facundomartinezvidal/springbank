package com.fmartinezvidal.springbank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class CreditCard extends Card {

    private final BigDecimal creditLimit;

    private CreditCard(Long id, String cardNumber, LocalDate expirationDate, Long clientId, BigDecimal creditLimit) {
        super(id, cardNumber, CardType.CREDIT, expirationDate, clientId);
        this.creditLimit = creditLimit;
    }

    public static CreditCard issue(String cardNumber, LocalDate expirationDate, Long clientId, BigDecimal creditLimit) {
        requireCardNumber(cardNumber);
        requireExpirationDate(expirationDate);
        requireClientId(clientId);
        if (creditLimit == null || creditLimit.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("creditLimit debe ser positivo");
        }
        return new CreditCard(null, cardNumber, expirationDate, clientId, creditLimit);
    }

    public static CreditCard reconstitute(Long id, String cardNumber, LocalDate expirationDate,
                                           Long clientId, BigDecimal creditLimit) {
        return new CreditCard(id, cardNumber, expirationDate, clientId, creditLimit);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }
}
