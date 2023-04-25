package com.artgallery.api.bankaccount;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BankAccountDto {
    private Long id;
    private String name;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccountDto() {
    }

    public BankAccountDto(Long id) {
        this.id = id;
    }
}
