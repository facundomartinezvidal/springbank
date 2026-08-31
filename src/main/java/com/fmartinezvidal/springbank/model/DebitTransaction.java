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
public class DebitTransaction extends Transaction {

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;



}
