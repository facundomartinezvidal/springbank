package com.fmartinezvidal.springbank.domain.model;

import java.time.LocalDate;

public sealed abstract class Card permits DebitCard, CreditCard {

    private final Long id;
    private final String cardNumber;
    private final CardType cardType;
    private final LocalDate expirationDate;
    private final Long clientId;

    protected Card(Long id, String cardNumber, CardType cardType, LocalDate expirationDate, Long clientId) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.clientId = clientId;
    }

    protected static void requireCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isBlank()) {
            throw new IllegalArgumentException("cardNumber es obligatorio");
        }
    }

    protected static void requireExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("expirationDate es obligatoria");
        }
    }

    protected static void requireClientId(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("clientId es obligatorio");
        }
    }

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Long getClientId() {
        return clientId;
    }
}
