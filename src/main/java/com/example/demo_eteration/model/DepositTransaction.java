package com.example.demo_eteration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepositTransaction extends Transaction {



    public DepositTransaction(Double amount) {
        this.setAmount(amount);

    }
    @Override
    public void executeTransaction(BankAccount account) {


    }

    @Override
    public String toString() {
        return "date: " + "\"" + this.getDate() + "\"" + "\namount: " + this.getAmount() +
                "\n\"type\": \"DepositTransaction\"" + "\n\"approvalCode\":" + "\"" + this.getApprovalCode() + "\"";
    }
}
