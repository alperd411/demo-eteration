package com.example.demo_eteration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBillPaymentRequest {
    public String serviceName;
    public String phoneNumber;
    public double amount;
}
