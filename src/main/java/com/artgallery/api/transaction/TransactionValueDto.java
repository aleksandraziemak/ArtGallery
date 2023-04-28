package com.artgallery.api.transaction;

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
    private TransactionCurrencyDto currency;
    private BigDecimal value;
}
