package com.example.demo_eteration.service.serviceImpl;

import com.example.demo_eteration.model.BankAccount;
import com.example.demo_eteration.repository.IBankAccountRepository;
import com.example.demo_eteration.service.BankAccountRepositoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountRepositoryServiceImpl implements BankAccountRepositoryService {

    private final IBankAccountRepository repository;

    public BankAccountRepositoryServiceImpl(IBankAccountRepository IBankAccountRepository) {
        this.repository = IBankAccountRepository;
    }

    @Override
    public void saveBankAccount(BankAccount account) {
        this.repository.save(account);
    }
    @Override
    public void updateAccount(BankAccount account){
        repository.save(account);
        repository.flush(); //commiting immediately
    }
    @Override
    public Optional<BankAccount> getBankAccountById(Long id){

        return repository.findById(id);

    }
    @Override
    public Optional<BankAccount> getBankAccountByAccountNumber(String accountNumber){

        return repository.findBankAccountByAccountNumber(accountNumber);
    }
}
