package com.artgallery.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
}
