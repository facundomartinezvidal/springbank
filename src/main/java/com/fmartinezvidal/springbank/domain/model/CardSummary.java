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
public class CardSummary {

    private Long id;
    private LocalDate closeDate;
    private LocalDate dueDate;
    private BigDecimal totalAmount;
    private BigDecimal minimumAmount;
    private Card card;
}
