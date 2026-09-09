package com.fmartinezvidal.springbank.domain.model;

import java.time.LocalDate;

public final class DebitCard extends Card {

    private final Long accountId;

    private DebitCard(Long id, String cardNumber, LocalDate expirationDate, Long clientId, Long accountId) {
        super(id, cardNumber, CardType.DEBIT, expirationDate, clientId);
        this.accountId = accountId;
    }

    public static DebitCard issue(String cardNumber, LocalDate expirationDate, Long clientId, Long accountId) {
        requireCardNumber(cardNumber);
        requireExpirationDate(expirationDate);
        requireClientId(clientId);
        if (accountId == null) {
            throw new IllegalArgumentException("accountId es obligatorio para una tarjeta de debito");
        }
        return new DebitCard(null, cardNumber, expirationDate, clientId, accountId);
    }

    public static DebitCard reconstitute(Long id, String cardNumber, LocalDate expirationDate,
                                          Long clientId, Long accountId) {
        return new DebitCard(id, cardNumber, expirationDate, clientId, accountId);
    }

    public Long getAccountId() {
        return accountId;
    }
}
