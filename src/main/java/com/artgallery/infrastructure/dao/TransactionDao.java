package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.TRANSACTION;

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

    public List<Transaction> getTransactions() {
        return dslContext.selectFrom(TRANSACTION)
            .fetch()
            .map(ArtMapper::mapTransaction);
    }

    public Long addTransaction(Transaction transaction) {
        return dslContext.insertInto(TRANSACTION,
                TRANSACTION.PAINTING_ID, TRANSACTION.CURATOR_ID, TRANSACTION.CLIENT_ID,
                TRANSACTION.BANK_ACCOUNT_ID, TRANSACTION.VALUE, TRANSACTION.DATE, TRANSACTION.TYPE)
            .values(transaction.getPaintingId(), transaction.getCuratorId(), transaction.getClientId(),
                transaction.getBankAccountId(), transaction.getTransactionValue().getValue(),
                transaction.getDate(), transaction.getType().name())
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