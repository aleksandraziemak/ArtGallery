package com.artgallery.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExchangeRate {
    private BigDecimal value;
    private Currency currency;
}
