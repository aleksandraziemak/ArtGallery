package com.artgallery.infrastructure.nbp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("nbp")
public class NbpProperties {
    private String host;
    private String currencyPath;
    private String exchangeRates;
}
