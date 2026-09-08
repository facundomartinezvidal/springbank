package com.fmartinezvidal.springbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private Long id;
    private String cardNumber;
    private CardType cardType;
    private LocalDate expirationDate;
    private BigDecimal limit;
    private Client client;
    private Account account;
}
