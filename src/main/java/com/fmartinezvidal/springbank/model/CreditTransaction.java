package com.fmartinezvidal.springbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditTransaction extends Transaction {

    private int installments;
    private int currentInstallment;
    @ManyToOne
    private CardSummary cardSummary;


}
