package com.example.demo_eteration.repository;

import com.example.demo_eteration.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBankAccountRepository  extends JpaRepository<BankAccount,Long> {

    public Optional<BankAccount> findBankAccountByAccountNumber(String accountNumber);
}
