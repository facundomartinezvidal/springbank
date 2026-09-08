package com.fmartinezvidal.springbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditTransaction extends Transaction {

    private int installments;
    private int currentInstallment;
    private CardSummary cardSummary;
}
