package com.artgallery.infrastructure;

import com.artgallery.domain.TransactionRepository;
import com.artgallery.domain.model.Transaction;
import com.artgallery.infrastructure.dao.TransactionDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionDao transactionDao;

    @Override
    public List<Transaction> getTransactions() {
        return transactionDao.getTransactions();
    }

    @Override
    public Long addTransaction(Transaction transaction) {
        return transactionDao.addTransaction(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionDao.deleteTransaction(id);
    }
}