package com.example.demo_eteration.service.serviceImpl;

import com.example.demo_eteration.model.BankAccount;
import com.example.demo_eteration.model.InsufficientBalanceException;
import com.example.demo_eteration.model.Transaction;
import com.example.demo_eteration.service.BankAccountRepositoryService;
import com.example.demo_eteration.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepositoryService bankAccountRepositoryService;

    public AccountServiceImpl(BankAccountRepositoryService bankAccountRepositoryService) {
        this.bankAccountRepositoryService = bankAccountRepositoryService;

    }
    @Override
    public BankAccount executeTransaction(Transaction transaction, BankAccount account)
            throws InsufficientBalanceException{
        BankAccount accountToUpdate = transaction.executeTransaction(account);
        bankAccountRepositoryService.updateAccount(accountToUpdate);
        return account;

    }

}
