package com.example.demo_eteration.model;

import com.example.demo_eteration.dto.TransactionSummaryDto;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
public class TransactionSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String type;
    private double amount;
    private String approvalCode;
    @ManyToOne
    @JoinColumn(name="transaction_id", nullable=false)
    private BankAccount bankAccount;

    public TransactionSummary(Date date, String type, double amount,String approvalCode, BankAccount account) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.approvalCode = approvalCode;
        this.bankAccount = account;
    }

    public TransactionSummary() {

    }
    public TransactionSummaryDto createSummaryDto(){
        return new TransactionSummaryDto(this.date,this.type,this.amount,this.approvalCode);

    }
}
