package com.artgallery.domain.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Long id;
    private TransactionType type;
    private Long paintingId;
    private Long clientId;
    private Long curatorId;
    private Long bankAccountId;
    private TransactionValue transactionValue;
    private TransactionValue originalTransactionValue;
    private LocalDate date;

    public Transaction(Long id) {
        this.id = id;
    }
}
