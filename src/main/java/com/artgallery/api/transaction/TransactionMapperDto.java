package com.artgallery.api.transaction;

import com.artgallery.domain.model.Transaction;
import com.artgallery.domain.model.TransactionType;
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
        transactionDto.setValue(transaction.getValue());
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
        transaction.setValue(transactionDto.getValue());
        transaction.setDate(transactionDto.getDate());
        transaction.setType(TransactionType.valueOf(transactionDto.getType().name()));
        return transaction;
    }
}