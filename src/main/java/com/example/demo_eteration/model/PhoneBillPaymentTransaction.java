package com.example.demo_eteration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneBillPaymentTransaction extends Transaction {

    private String serviceName;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String serviceName, String phoneNumber, double amount) {

        this.serviceName = serviceName;
        this.phoneNumber = phoneNumber;
        setAmount(amount);

    }


}
