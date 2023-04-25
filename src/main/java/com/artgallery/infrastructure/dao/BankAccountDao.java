package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.BANK_ACCOUNT;

import com.artgallery.domain.model.BankAccount;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BankAccountDao {

    private final DSLContext dslContext;

    public List<BankAccount> getBankAccounts() {
        return dslContext.selectFrom(BANK_ACCOUNT)
            .fetch()
            .map(ArtMapper::mapBankAccount);
    }

    public BankAccount find(Long id) {
        return dslContext.selectFrom(BANK_ACCOUNT)
            .where(BANK_ACCOUNT.ID.eq(id))
            .fetchOptional()
            .map(ArtMapper::mapBankAccount)
            .orElseThrow(() -> new IllegalStateException(String.format("Bank Account not found for ID %s", id)));
    }

    public Long addBankAccount(BankAccount bankAccount) {
        return dslContext.insertInto(BANK_ACCOUNT,
                BANK_ACCOUNT.NAME, BANK_ACCOUNT.ACCOUNT_NUMBER, BANK_ACCOUNT.BALANCE)
            .values(bankAccount.getName(), bankAccount.getAccountNumber(), bankAccount.getBalance())
            .returning()
            .fetchOne()
            .getId();
    }

    public void updateBankAccount(BankAccount bankAccount) {
        dslContext.update(BANK_ACCOUNT)
            .set(BANK_ACCOUNT.NAME, bankAccount.getName())
            .set(BANK_ACCOUNT.ACCOUNT_NUMBER, bankAccount.getAccountNumber())
            .set(BANK_ACCOUNT.BALANCE, bankAccount.getBalance())
            .where(BANK_ACCOUNT.ID.eq(bankAccount.getId()))
            .execute();
    }

    public void deleteBankAccount(Long id) {
        dslContext.deleteFrom(BANK_ACCOUNT)
            .where(BANK_ACCOUNT.ID.eq(id))
            .execute();
    }
}