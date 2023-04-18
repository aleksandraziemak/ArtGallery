package com.artgallery.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddTransactionDto {
    private Long id;
    private Long paintingId;
    private Long clientId;
    private Long curatorId;
    private Long bankAccountId;
    private BigDecimal value;
    private LocalDate date;

    public AddTransactionDto() {
    }

    public AddTransactionDto(Long id) {
        this.id = id;
    }
}
