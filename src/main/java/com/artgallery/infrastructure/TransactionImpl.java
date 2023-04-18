package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.CLIENT;
import static com.artgallery.dao.db.Tables.TRANSACTION;

import com.artgallery.domain.ClientRepository;
import com.artgallery.domain.TransactionRepository;
import com.artgallery.domain.model.Client;
import com.artgallery.domain.model.Transaction;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionImpl implements TransactionRepository {

    private final DSLContext dslContext;

    public TransactionImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Transaction> getTransactions() {
        return dslContext.selectFrom(TRANSACTION)
            .fetch()
            .map(ArtMapper::mapTransaction);
    }

    @Override
    public Long addTransaction(Transaction transaction) {
        return dslContext.insertInto(TRANSACTION,
                TRANSACTION.PAINTING_ID, TRANSACTION.CURATOR_ID, TRANSACTION.CLIENT_ID,
                TRANSACTION.BANK_ACCOUNT_ID, TRANSACTION.VALUE, TRANSACTION.DATE)
            .values(transaction.getPaintingId(), transaction.getCuratorId(), transaction.getClientId(),
                transaction.getBankAccountId(), transaction.getValue(), transaction.getDate())
            .returning()
            .fetchOne()
            .getId();
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        dslContext.update(TRANSACTION)
            .set(TRANSACTION.PAINTING_ID, transaction.getPaintingId())
            .set(TRANSACTION.CURATOR_ID, transaction.getCuratorId())
            .set(TRANSACTION.CLIENT_ID, transaction.getClientId())
            .set(TRANSACTION.BANK_ACCOUNT_ID, transaction.getBankAccountId())
            .set(TRANSACTION.VALUE, transaction.getValue())
            .set(TRANSACTION.DATE, transaction.getDate())
            .where(TRANSACTION.ID.eq(transaction.getId()))
            .execute();
    }

    @Override
    public void deleteTransaction(Long id) {
        dslContext.deleteFrom(TRANSACTION)
            .where(TRANSACTION.ID.eq(id))
            .execute();
    }
}