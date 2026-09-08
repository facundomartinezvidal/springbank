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
public class Installment {

    private Long id;
    private LocalDate dueDate;
    private BigDecimal amount;
    private StatusInstallment status;
    private Loan loan;
}
