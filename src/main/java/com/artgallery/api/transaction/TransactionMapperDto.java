package com.artgallery.api.transaction;

import com.artgallery.api.CurrencyDto;
import com.artgallery.domain.model.Currency;
import com.artgallery.domain.model.Transaction;
import com.artgallery.domain.model.TransactionType;
import com.artgallery.domain.model.TransactionValue;
import java.util.List;

public class TransactionMapperDto {

    public static List<TransactionDto> map(List<Transaction> transactions) {
        return transactions.stream()
            .map(TransactionMapperDto::map)
            .toList();
    }

    public static TransactionDto map(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setPaintingId(transaction.getPaintingId());
        transactionDto.setCuratorId(transaction.getCuratorId());
        transactionDto.setClientId(transaction.getClientId());
        transactionDto.setBankAccountId(transaction.getBankAccountId());
        transactionDto.setTransactionValue(map(transaction.getTransactionValue()));
        transactionDto.setOriginalTransactionValue(map(transaction.getOriginalTransactionValue()));
        transactionDto.setDate(transaction.getDate());
        transactionDto.setType(TransactionTypeDto.valueOf(transaction.getType().name()));
        return transactionDto;
    }

    public static Transaction map(AddTransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setPaintingId(transactionDto.getPaintingId());
        transaction.setCuratorId(transactionDto.getCuratorId());
        transaction.setClientId(transactionDto.getClientId());
        transaction.setBankAccountId(transactionDto.getBankAccountId());
        transaction.setTransactionValue(map(transactionDto.getTransactionValue()));
        transaction.setOriginalTransactionValue(map(transactionDto.getTransactionValue()));
        transaction.setDate(transactionDto.getDate());
        transaction.setType(TransactionType.valueOf(transactionDto.getType().name()));
        return transaction;
    }

    private static TransactionValue map(AddTransactionValueDto transactionValueDto) {
        TransactionValue transactionValue = new TransactionValue();
        transactionValue.setValue(transactionValueDto.getValue());
        transactionValue.setCurrency(Currency.valueOf(transactionValueDto.getCurrency().name()));
        return transactionValue;
    }

    private static TransactionValueDto map(TransactionValue transactionValue) {
        TransactionValueDto transactionValueDto = new TransactionValueDto();
        transactionValueDto.setValue(transactionValue.getValue());
        transactionValueDto.setCurrency(CurrencyDto.valueOf(transactionValue.getCurrency().name()));
        return transactionValueDto;
    }
}