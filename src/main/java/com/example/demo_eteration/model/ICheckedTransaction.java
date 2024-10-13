package com.example.demo_eteration.model;

/**
 * This interface is for transactions to be deducted from the account
 * Every negative deposit transaction should implement this for balance sufficiency
 */
public interface ICheckedTransaction {
    default Boolean isBalanceSufficient(double balance, double amount){

        return (balance>amount);
    };
}
