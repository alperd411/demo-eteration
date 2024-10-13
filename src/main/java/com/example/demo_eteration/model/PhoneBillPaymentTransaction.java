package com.example.demo_eteration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneBillPaymentTransaction extends Transaction implements ICheckedTransaction {

    private String serviceName;
    private String phoneNumber;
    private final String type = "PhoneBillPaymentTransaction";

    public PhoneBillPaymentTransaction(String serviceName, String phoneNumber, double amount) {

        this.serviceName = serviceName;
        this.phoneNumber = phoneNumber;
        this.setAmount(amount);

    }


    @Override
    public BankAccount executeTransaction(BankAccount account) throws InsufficientBalanceException {
        if (!isBalanceSufficient(account.getBalance(),this.getAmount()))
            throw new InsufficientBalanceException();

        double updatedBalance = account.getBalance() - this.getAmount();
        account.setBalance(updatedBalance);
        account.addTransactionToAccountHistory(this.buildSummary(this.type,account));
        return account;
    }

}
