package com.artgallery.domain.model;

import java.util.Date;

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

    public Transaction(Long id, Long paintingId, Long clientId, Long curatorId, Long bankAccountId, Long value, Date date) {
        this.id = id;
        this.paintingId = paintingId;
        this.clientId = clientId;
        this.curatorId = curatorId;
        this.bankAccountId = bankAccountId;
        this.value = value;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(Long paintingId) {
        this.paintingId = paintingId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(Long curatorId) {
        this.curatorId = curatorId;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
