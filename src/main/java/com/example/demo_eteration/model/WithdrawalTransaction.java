package com.example.demo_eteration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WithdrawalTransaction extends Transaction implements ICheckedTransaction {

    private final String type = "WithdrawalTransaction";

    public WithdrawalTransaction(double amount) {
        this.setAmount(amount);
    }

    @Override
    public BankAccount executeTransaction(BankAccount account) throws InsufficientBalanceException {
        if (!isBalanceSufficient(account.getBalance(), this.getAmount()))
            throw new InsufficientBalanceException();

        account.setBalance(account.getBalance()-this.getAmount());
        account.addTransactionToAccountHistory(this.buildSummary(this.type,account));
        return account;
    }


}
