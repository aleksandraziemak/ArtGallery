package com.artgallery.infrastructure.nbp;

import com.artgallery.domain.model.Currency;
import com.artgallery.domain.model.ExchangeRate;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
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
        Currency.USD, "usd",
        Currency.PLN, "pln",
        Currency.CHF, "chf"
    );

    public List<ExchangeRate> getExchangeRates() {
        List<NbpExchangeRatesResponse> list = Arrays.stream(Optional.ofNullable(restTemplate.getForObject(
                    nbpProperties.getHost() + nbpProperties.getExchangeRates(),
                    NbpExchangeRatesResponse[].class))
                .orElseThrow(() -> new IllegalStateException("NBP not responding")))
            .findFirst()
            .map(Arrays::asList)
            .orElseThrow(() -> new IllegalStateException("Cannot map Currency Response"));

        return Arrays.stream(Currency.values())
            .map(currency -> list.get(0).getRates().stream()
                .filter(r -> r.getCode().equals(currency.name()))
                .findFirst()
                .map(rate -> new ExchangeRate(BigDecimal.valueOf(rate.getBid()), Currency.valueOf(rate.getCode())))
                .orElse(null)
            ).filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
}
