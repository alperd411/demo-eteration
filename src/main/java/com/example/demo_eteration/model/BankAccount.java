package com.example.demo_eteration.model;

import com.example.demo_eteration.dto.AccountDto;
import com.example.demo_eteration.dto.TransactionSummaryDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNumber;
    private String owner;
    private double balance;
    @Builder.Default
    private final String createdDate  = new Date().toString();
    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<TransactionSummary> transactions = new ArrayList<>();

    public void addTransactionToAccountHistory(TransactionSummary transactionSummary){

        transactions.add(transactionSummary);
    }
    public AccountDto createDtoObject(){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(this.accountNumber);
        accountDto.setOwner(this.owner);
        accountDto.setBalance(this.balance);
        List<TransactionSummaryDto> transactionSummaries = new ArrayList<>();
        this.transactions.forEach(transactionSummary ->
            {transactionSummaries.add(transactionSummary.createSummaryDto());});
        accountDto.setTransactions(transactionSummaries);
        return accountDto;

    }
}
