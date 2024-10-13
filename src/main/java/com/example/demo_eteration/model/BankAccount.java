package com.example.demo_eteration.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;
    @Builder.Default
    private final String createdDate  = new Date().toString();
    private ArrayList<String> transactions;

    public BankAccount post(DepositTransaction depositTransaction){

        this.balance += depositTransaction.getAmount();
        this.transactions.add(depositTransaction.toString());
        return this;
    }

    public BankAccount post(WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {

        if (this.balance < withdrawalTransaction.getAmount()){
            throw  new InsufficientBalanceException();
        }

        this.balance -= withdrawalTransaction.getAmount();
        this.transactions.add(withdrawalTransaction.toString());
        return this;

    }

    public BankAccount post(PhoneBillPaymentTransaction phoneBillPaymentTransaction)
            throws InsufficientBalanceException {

        if (this.balance < phoneBillPaymentTransaction.getAmount())
            throw  new InsufficientBalanceException();
        this.balance -= phoneBillPaymentTransaction.getAmount();
        this.transactions.add(phoneBillPaymentTransaction.toString());
        return this;

    }


}
