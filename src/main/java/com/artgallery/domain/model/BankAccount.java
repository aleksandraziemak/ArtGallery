package com.artgallery.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private Long id;
    private String name;
    private String accountNumber;
    private BigDecimal balance;
    private Currency currency;

    public BankAccount(Long id) {
        this.id = id;
    }
}
