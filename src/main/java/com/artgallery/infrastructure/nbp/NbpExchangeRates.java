package com.artgallery.infrastructure.nbp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NbpExchangeRates {
    private String currency;
    private String code;
    private float bid;
    private float ask;
}
