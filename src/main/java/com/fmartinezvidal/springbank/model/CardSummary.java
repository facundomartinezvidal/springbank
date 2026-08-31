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
public class CardSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate closeDate;
    @Column(nullable = false)
    private LocalDate dueDate;
    @Column(precision = 10, scale = 2)
    private BigDecimal totalAmount;
    @Column(precision = 10, scale = 2)
    private BigDecimal minimumAmount;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;


}
