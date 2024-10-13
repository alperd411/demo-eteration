package com.example.demo_eteration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class TransactionSummaryDto {
    private Date date;
    private String type;
    private double amount;
    private String approvalCode;
}
