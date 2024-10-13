package com.example.demo_eteration.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class  Transaction {

    private double amount;
    private final Date date = new Date();
    private final String  approvalCode = UUID.randomUUID().toString();

    public void executeTransaction(BankAccount account) {



    }
}
