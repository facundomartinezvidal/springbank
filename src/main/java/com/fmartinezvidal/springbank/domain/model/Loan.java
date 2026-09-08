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
public class Loan {

    private Long id;
    private BigDecimal interestRate;
    private int installmentCount;
    private BigDecimal amount;
    private LocalDate startDate;
    private Client client;
}
