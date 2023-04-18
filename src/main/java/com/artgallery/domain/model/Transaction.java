package com.artgallery.domain.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Long paintingId;
    private Long clientId;
    private Long curatorId;
    private Long bankAccountId;
    private Long value;
    private Date date;

    public Transaction() {
    }

    public Transaction(Long id) {
        this.id = id;
    }
}
