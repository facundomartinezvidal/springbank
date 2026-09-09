package com.fmartinezvidal.springbank.domain.model;

import com.fmartinezvidal.springbank.domain.exception.InsufficientFundsException;

import java.math.BigDecimal;

public class Account {

    private final Long id;
    private final AccountType accountType;
    private BigDecimal balance;
    private final String accountNumber;
    private final Long clientId;

    private Account(Long id, AccountType accountType, BigDecimal balance, String accountNumber, Long clientId) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.clientId = clientId;
    }

    // apertura de una cuenta nueva
    public static Account open(AccountType accountType, String accountNumber, Long clientId) {
        if (accountType == null) {
            throw new IllegalArgumentException("accountType es obligatorio");
        }
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("accountNumber es obligatorio");
        }
        if (clientId == null) {
            throw new IllegalArgumentException("clientId es obligatorio");
        }
        return new Account(null, accountType, BigDecimal.ZERO, accountNumber, clientId);
    }

    // reconstruccion desde persistencia (datos ya validados en su momento)
    public static Account reconstitute(Long id, AccountType accountType, BigDecimal balance,
                                        String accountNumber, Long clientId) {
        return new Account(id, accountType, balance, accountNumber, clientId);
    }

    public void deposit(BigDecimal amount) {
        requirePositive(amount);
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        requirePositive(amount);
        if (this.balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException(accountNumber);
        }
        this.balance = this.balance.subtract(amount);
    }

    private static void requirePositive(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount debe ser positivo");
        }
    }

    public Long getId() {
        return id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Long getClientId() {
        return clientId;
    }
}
