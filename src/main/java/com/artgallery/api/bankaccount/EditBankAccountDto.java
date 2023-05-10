package com.artgallery.api.bankaccount;

import com.artgallery.api.CurrencyDto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditBankAccountDto {
    private Long id;
    private String name;
    private String accountNumber;
    private BigDecimal balance;
    private CurrencyDto currency;
}
