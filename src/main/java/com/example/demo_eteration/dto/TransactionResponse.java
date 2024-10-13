package com.example.demo_eteration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionResponse {
    private String status;
    private String approvalCode;
}
