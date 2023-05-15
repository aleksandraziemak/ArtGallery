package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.TRANSACTION;

import com.artgallery.domain.BankAccountRepository;
import com.artgallery.domain.model.Transaction;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDao {

    private final DSLContext dslContext;
    private final BankAccountRepository bankAccountRepository;

    public List<Transaction> getTransactions() {
        return dslContext.selectFrom(TRANSACTION)
            .fetch()
            .map(ArtMapper::mapTransaction);
    }

    public Long addTransaction(Transaction transaction) {
        return dslContext.insertInto(TRANSACTION)
            .set(TRANSACTION.PAINTING_ID, transaction.getPaintingId())
            .set(TRANSACTION.CURATOR_ID, transaction.getCuratorId())
            .set(TRANSACTION.CLIENT_ID, transaction.getClientId())
            .set(TRANSACTION.BANK_ACCOUNT_ID, transaction.getBankAccountId())
            .set(TRANSACTION.TYPE, transaction.getType().name())
            .set(TRANSACTION.VALUE, transaction.getTransactionValue().getValue())
            .set(TRANSACTION.VALUE_CURRENCY, transaction.getTransactionValue().getCurrency().name())
            .set(TRANSACTION.ORIGINAL_VALUE, transaction.getOriginalTransactionValue().getValue())
            .set(TRANSACTION.ORIGINAL_VALUE_CURRENCY, transaction.getOriginalTransactionValue().getCurrency().name())
            .set(TRANSACTION.DATE, transaction.getDate())
            .returning()
            .fetchOne()
            .getId();
    }

    public void deleteTransaction(Long id) {
        dslContext.deleteFrom(TRANSACTION)
            .where(TRANSACTION.ID.eq(id))
            .execute();
    }
}