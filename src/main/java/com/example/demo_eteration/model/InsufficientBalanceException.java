package com.example.demo_eteration.model;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(){

        super("Account balance Insufficient");

    }
}
