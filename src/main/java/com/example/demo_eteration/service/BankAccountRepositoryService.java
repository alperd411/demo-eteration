package com.example.demo_eteration.service;

import com.example.demo_eteration.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface BankAccountRepositoryService {

    void updateAccount(BankAccount account);
    Optional<BankAccount> getBankAccountById(Long id);
    Optional<BankAccount> getBankAccountByAccountNumber(String accountNumber);
    void saveBankAccount(BankAccount bankAccount);
}
