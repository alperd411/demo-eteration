package com.example.demo_eteration.service;

import com.example.demo_eteration.model.BankAccount;
import com.example.demo_eteration.model.InsufficientBalanceException;
import com.example.demo_eteration.model.Transaction;
import org.springframework.stereotype.Service;

public interface AccountService {
    public BankAccount executeTransaction(Transaction transaction, BankAccount account)
            throws InsufficientBalanceException;

}
