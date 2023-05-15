package com.artgallery.api.painting;

import com.artgallery.api.CurrencyDto;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaintingEstimatedPriceDto {
    private BigDecimal estimatedPrice;
    private CurrencyDto currency;
}
