package com.artgallery.domain;

import com.artgallery.domain.model.Transaction;
import java.util.List;

public interface TransactionRepository {

    List<Transaction> getTransactions();

    Long addTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);

    void deleteTransaction(Long id);
}