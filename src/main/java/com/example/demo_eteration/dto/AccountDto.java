package com.example.demo_eteration.dto;

import com.example.demo_eteration.model.BankAccount;
import com.example.demo_eteration.model.TransactionSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String accountNumber;
    private String owner;
    private double balance;
    private List<TransactionSummaryDto> transactions;
    public BankAccount createBankAccount() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(this.accountNumber);
        bankAccount.setOwner(this.owner);
        bankAccount.setBalance(this.balance);

        return bankAccount;
    }
}
