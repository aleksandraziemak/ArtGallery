package com.artgallery.domain.model;

public class BankAccount {
    private Long id;
    private String name;
    private String accountNumber;
    private Long balance;

    public BankAccount() {
    }

    public BankAccount(Long id) {
        this.id = id;
    }

    public BankAccount(Long id, String name, String accountNumber, Long balance) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
