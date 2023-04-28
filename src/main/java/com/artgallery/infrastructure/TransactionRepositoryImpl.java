package com.artgallery.infrastructure;

import com.artgallery.domain.TransactionRepository;
import com.artgallery.domain.model.Transaction;
import com.artgallery.domain.model.TransactionCurrency;
import com.artgallery.domain.model.TransactionValue;
import com.artgallery.infrastructure.dao.TransactionDao;
import com.artgallery.infrastructure.nbp.NbpAdapter;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionDao transactionDao;
    private final NbpAdapter nbpAdapter;

    @Override
    public List<Transaction> getTransactions() {
        return transactionDao.getTransactions();
    }

    @Override
    public Long addTransaction(Transaction transaction) {
        if (transaction.getTransactionValue().getCurrency() != TransactionCurrency.PLN) {
            transaction.setTransactionValue(calculateValue(transaction));
        }
        return transactionDao.addTransaction(transaction);
    }

    private TransactionValue calculateValue(Transaction transaction) {
        return new TransactionValue(TransactionCurrency.PLN,
            transaction.getTransactionValue().getValue().multiply(BigDecimal.valueOf(nbpAdapter.getCurrency(transaction))));
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionDao.deleteTransaction(id);
    }
}