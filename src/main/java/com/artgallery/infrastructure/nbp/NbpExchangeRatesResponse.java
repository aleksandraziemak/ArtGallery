package com.artgallery.infrastructure.nbp;


import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NbpExchangeRatesResponse {
    private List<NbpExchangeRates> rates;
}
