package com.example.demo_eteration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double amount) {
        this.setAmount(amount);
    }

}
