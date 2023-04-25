package com.artgallery.api.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTransactionDto {
    private TransactionTypeDto type;
    private Long paintingId;
    private Long clientId;
    private Long curatorId;
    private Long bankAccountId;
    private BigDecimal value;
    private LocalDate date;
}
