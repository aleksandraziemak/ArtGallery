package com.artgallery.domain.model;

import java.math.BigDecimal;
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
    private BigDecimal balance;

    public BankAccount() {
    }

    public BankAccount(Long id) {
        this.id = id;
    }
}
