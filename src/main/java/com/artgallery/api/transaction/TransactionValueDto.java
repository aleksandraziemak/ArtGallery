package com.artgallery.api.transaction;

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
public class TransactionValueDto {
    private CurrencyDto currency;
    private BigDecimal value;
}
