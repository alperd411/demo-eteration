package com.example.demo_eteration;

import com.example.demo_eteration.model.*;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountFunctionTest {

    @Test
    public void test() throws InsufficientBalanceException {

        BankAccount account = BankAccount.builder().accountNumber("001").owner("alper demir")
                .transactions(new ArrayList<String>()).build();
        account.post(new DepositTransaction(1000.0));
        account.post(new WithdrawalTransaction(200.0));
        account.post(new PhoneBillPaymentTransaction("Vodafone", "5465465555",96.50));

        assertEquals(account.getBalance(), 703.50, 0.0001);


    }
    @Test
    public void ShouldFail() throws InsufficientBalanceException {

        BankAccount account = BankAccount.builder().accountNumber("001").owner("alper demir")
                .transactions(new ArrayList<String>()).build();
        account.post(new DepositTransaction(1000.0));
        assertThrows(InsufficientBalanceException.class, () -> account.post(new WithdrawalTransaction(2000.0)));

    }

}