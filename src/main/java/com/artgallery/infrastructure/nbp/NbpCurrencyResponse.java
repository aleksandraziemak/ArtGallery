package com.artgallery.infrastructure.nbp;


import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NbpCurrencyResponse {
    private String currency;
    private List<NbpRates> rates;
}
