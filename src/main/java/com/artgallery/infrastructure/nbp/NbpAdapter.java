package com.artgallery.infrastructure.nbp;

import com.artgallery.domain.model.Transaction;
import com.artgallery.domain.model.Currency;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@EnableConfigurationProperties(NbpProperties.class)
public class NbpAdapter {
    private final RestTemplate restTemplate;
    private final NbpProperties nbpProperties;
    private static final Map<Currency, String> MAP = Map.of(
        Currency.EUR, "eur",
        Currency.USD, "usd"
    );

    public Float getCurrency(Transaction transaction) {
        return Optional.ofNullable(restTemplate.getForObject(nbpProperties.getHost() + nbpProperties.getCurrencyPath(),
                NbpCurrencyResponse.class, MAP.get(transaction.getTransactionValue().getCurrency())))
            .orElseThrow(() -> new IllegalStateException("NBP not responding"))
            .getRates()
            .stream()
            .findFirst()
            .map(NbpRates::getBid)
            .orElseThrow(() -> new IllegalStateException("Cannot map Currency Response"));
    }
}
