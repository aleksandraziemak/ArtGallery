package com.artgallery.domain;

import com.artgallery.api.transaction.TransactionService;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;
import com.artgallery.domain.model.Transaction;
import com.artgallery.domain.model.TransactionType;
import java.util.List;
import java.util.Map;
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
}