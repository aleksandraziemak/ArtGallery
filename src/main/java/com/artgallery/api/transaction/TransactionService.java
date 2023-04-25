package com.artgallery.api.transaction;

import com.artgallery.domain.model.Transaction;
import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactions();

    void addTransaction(Transaction transaction);

    void deleteTransaction(Long id);
}
