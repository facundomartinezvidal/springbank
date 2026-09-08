package com.fmartinezvidal.springbank.infrastructure.persistence.entity;

import com.fmartinezvidal.springbank.domain.model.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {

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
    @Column(name = "credit_limit")
    private BigDecimal limit;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ClientEntity client;
    @ManyToOne
    private AccountEntity account;
}
