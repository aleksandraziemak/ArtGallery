package com.artgallery.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private Long id;
    private TransactionType type;
    private Long paintingId;
    private Long clientId;
    private Long curatorId;
    private Long bankAccountId;
    private BigDecimal value;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(Long id) {
        this.id = id;
    }
}
