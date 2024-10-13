package com.example.demo_eteration.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public abstract class  Transaction {

    public double amount;
    public final Date date = new Date();
    public final String  approvalCode = UUID.randomUUID().toString();
    public String type;

    public abstract BankAccount executeTransaction(BankAccount account) throws InsufficientBalanceException;

    public TransactionSummary buildSummary(String type,BankAccount account) {

        return new TransactionSummary(
                this.date,
                type,
                this.amount,
                this.approvalCode,
                account
        );

    }
}
