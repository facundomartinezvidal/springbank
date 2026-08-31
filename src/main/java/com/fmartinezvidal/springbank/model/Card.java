package com.fmartinezvidal.springbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String cardNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @Column(nullable = false)
    private LocalDate expirationDate;
    private BigDecimal limit;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;
    @ManyToOne
    private Account account;
}
