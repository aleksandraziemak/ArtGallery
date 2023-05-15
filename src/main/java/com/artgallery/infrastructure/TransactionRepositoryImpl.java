package com.artgallery.infrastructure;

import com.artgallery.domain.TransactionRepository;
import com.artgallery.domain.model.Currency;
import com.artgallery.domain.model.ExchangeRate;
import com.artgallery.domain.model.Transaction;
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
        return transactionDao.addTransaction(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionDao.deleteTransaction(id);
    }

    @Override
    public List<ExchangeRate> getExchangeRates() {
        List<ExchangeRate> list = nbpAdapter.getExchangeRates();
        list.add(new ExchangeRate(BigDecimal.valueOf(1.00), Currency.PLN));
        return list;
    }
}