package com.artgallery.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaintingEstimatedPrice {
    private BigDecimal estimatedPrice;
    private Currency currency;
}
