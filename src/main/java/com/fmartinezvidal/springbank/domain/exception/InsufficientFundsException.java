package com.fmartinezvidal.springbank.domain.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String accountNumber) {
        super("Fondos insuficientes en la cuenta " + accountNumber);
    }
}
