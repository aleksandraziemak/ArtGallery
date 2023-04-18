package com.artgallery.api;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddBankAccountDto {
    private Long id;
    private String name;
    private String accountNumber;
    private BigDecimal balance;

    public AddBankAccountDto() {
    }

    public AddBankAccountDto(Long id) {
        this.id = id;
    }
}
