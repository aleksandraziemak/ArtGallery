package com.artgallery.domain;

import com.artgallery.api.transaction.TransactionService;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Currency;
import com.artgallery.domain.model.ExchangeRate;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;
import com.artgallery.domain.model.Transaction;
import com.artgallery.domain.model.TransactionType;
import com.artgallery.domain.model.TransactionValue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class TransactionServiceImpl implements TransactionService {

    private final PaintingRepository paintingRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    private static final Map<TransactionType, Status>  TRANSACTION_TYPE_STATUS_MAP = Map.of(
        TransactionType.SELL, Status.SOLD,
        TransactionType.IN_RENT, Status.IN_RENTAL,
        TransactionType.BUY, Status.OWNED,
        TransactionType.RENT, Status.RENTED
    );

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.getTransactions();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        Painting painting = paintingRepository.find(transaction.getPaintingId());
        BankAccount bankAccount = bankAccountRepository.find(transaction.getBankAccountId());
        checkTransactionValue(transaction, painting);
        if (transaction.getTransactionValue().getCurrency() != bankAccount.getCurrency()) {
            transaction.setTransactionValue(calculateValue(transaction, bankAccount.getCurrency()));
        }
        transactionRepository.addTransaction(transaction);
        updateStatusBalance(transaction);
    }

    private void updateStatusBalance(Transaction transaction) {
        Painting painting = paintingRepository.find(transaction.getPaintingId());
        BankAccount bankAccount = bankAccountRepository.find(transaction.getBankAccountId());
        painting.setStatus(TRANSACTION_TYPE_STATUS_MAP.get(transaction.getType()));
        switch (transaction.getType()) {
            case SELL, IN_RENT -> bankAccount.setBalance(bankAccount.getBalance().add(transaction.getTransactionValue().getValue()));
            case BUY, RENT -> bankAccount.setBalance(bankAccount.getBalance().subtract(transaction.getTransactionValue().getValue()));
            default -> throw new IllegalStateException("Wrong transaction type");
        }
        paintingRepository.updatePainting(painting);
        bankAccountRepository.updateBankAccount(bankAccount);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteTransaction(id);
    }


    private TransactionValue calculateValue(Transaction transaction, Currency currency) {
        Map<Currency, BigDecimal> map = transactionRepository.getExchangeRates().stream()
            .collect(Collectors.toMap(ExchangeRate::getCurrency, ExchangeRate::getValue));
        BigDecimal exchangeRate = map.get(transaction.getTransactionValue().getCurrency())
            .divide(map.get(currency), RoundingMode.CEILING);
        return new TransactionValue(formatBigDecimal(transaction.getTransactionValue().getValue().multiply(exchangeRate)),
            currency);
    }

    private void checkTransactionValue(Transaction transaction, Painting painting) {
        if (painting.getPaintingEstimatedPrice().getCurrency() == transaction.getTransactionValue().getCurrency()) {
            checkValue(transaction.getTransactionValue(), painting.getPaintingEstimatedPrice().getEstimatedPrice());
        } else {
            TransactionValue value = calculateValue(transaction, painting.getPaintingEstimatedPrice().getCurrency());
            checkValue(value, painting.getPaintingEstimatedPrice().getEstimatedPrice());
        }
    }

    private void checkValue(TransactionValue transactionValue, BigDecimal value) {
        if (value.compareTo(transactionValue.getValue()) > 0) {
            throw new IllegalStateException("Transaction value is lower than estimated price of painting");
        }
    }

    private BigDecimal formatBigDecimal(BigDecimal value) {
        return value.setScale(2, RoundingMode.CEILING);
    }
}