package com.artgallery.api.bankaccount;

import com.artgallery.api.CurrencyDto;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBankAccountDto {
    private Long id;
    private String name;
    private String accountNumber;
    private BigDecimal balance;
    private CurrencyDto currency;
}
