package com.example.demo_eteration.controller;

import com.example.demo_eteration.dto.AccountDto;
import com.example.demo_eteration.dto.PhoneBillPaymentRequest;
import com.example.demo_eteration.dto.TransactionRequest;
import com.example.demo_eteration.dto.TransactionResponse;
import com.example.demo_eteration.model.*;
import com.example.demo_eteration.service.AccountService;
import com.example.demo_eteration.service.BankAccountRepositoryService;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/account/v1")
public class AccountController {

    private final AccountService accountService;
    private final BankAccountRepositoryService bankAccountRepositoryService;


    public AccountController(AccountService accountService, BankAccountRepositoryService bankAccountRepositoryService) {
        this.accountService = accountService;
        this.bankAccountRepositoryService = bankAccountRepositoryService;
    }

    @GetMapping("/{accNumber}")
    public AccountDto getBankAccount(@PathVariable String accNumber) throws AccountNotFoundException {

        Optional<BankAccount> account =  bankAccountRepositoryService.getBankAccountByAccountNumber(accNumber);
        if (account.isPresent())
            return account.get().createDtoObject();
        else throw new AccountNotFoundException();

    }

    @PostMapping("")
    public BankAccount createBankAccount(@RequestBody AccountDto accountDto) {

        BankAccount account = accountDto.createBankAccount();
        bankAccountRepositoryService.saveBankAccount(account);
        return account;

    }

    @PostMapping("/debit/{accNumber}")
    public TransactionResponse debitBankAccount(@PathVariable String accNumber, @RequestBody TransactionRequest request)
            throws InsufficientBalanceException, AccountNotFoundException {

        Optional<BankAccount> account = bankAccountRepositoryService.getBankAccountByAccountNumber(accNumber);
        if (!account.isPresent()) {
            throw new AccountNotFoundException();
        }
        BankAccount acc = account.get();
        WithdrawalTransaction transaction = new WithdrawalTransaction(request.getAmount());
        BankAccount updatedAcc = accountService.executeTransaction(transaction,acc);
        return new TransactionResponse("Ok",
                transaction.getApprovalCode());
    }

    @PostMapping("/credit/{accNumber}")
    public TransactionResponse creditBankAccount(@PathVariable String accNumber, @RequestBody TransactionRequest request)
            throws InsufficientBalanceException, AccountNotFoundException {


        Optional<BankAccount> account = bankAccountRepositoryService.getBankAccountByAccountNumber(accNumber);
        if (!account.isPresent()) {
            throw new AccountNotFoundException();
        }
        BankAccount acc = account.get();
        DepositTransaction depositTransaction = new DepositTransaction(request.getAmount());
        BankAccount updatedAcc = accountService.executeTransaction(depositTransaction,acc);
        return new TransactionResponse("Ok",
                depositTransaction.getApprovalCode());
    }
    @PostMapping("/phoneBillPayment/{accNumber}")
    public TransactionResponse payPhoneBill(@PathVariable String accNumber, @RequestBody PhoneBillPaymentRequest request)
            throws AccountNotFoundException, InsufficientBalanceException {

        Optional<BankAccount> account = bankAccountRepositoryService.getBankAccountByAccountNumber(accNumber);
        if (!account.isPresent()) {
            throw new AccountNotFoundException();
        }
        BankAccount acc = account.get();
        PhoneBillPaymentTransaction transaction =
                new PhoneBillPaymentTransaction(request.getServiceName(),request.getPhoneNumber(),request.getAmount());
        accountService.executeTransaction(transaction,acc);
        return new TransactionResponse("Ok",transaction.getApprovalCode());

    }
}
