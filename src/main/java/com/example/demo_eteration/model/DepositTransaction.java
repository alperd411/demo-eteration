package com.example.demo_eteration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class DepositTransaction extends Transaction {

    private final String type = "DepositTransaction";

    public DepositTransaction(Double amount) {
        this.setAmount(amount);

    }
    @Override
    public BankAccount executeTransaction(BankAccount account) {
        account.setBalance(account.getBalance() + this.getAmount());
        account.addTransactionToAccountHistory(this.buildSummary(this.type,account));
        return account;
    }

}
