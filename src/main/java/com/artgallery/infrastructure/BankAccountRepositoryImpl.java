package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.BANK_ACCOUNT;
import static com.artgallery.dao.db.Tables.CLIENT;

import com.artgallery.domain.BankAccountRepository;
import com.artgallery.domain.ClientRepository;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Client;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    private final DSLContext dslContext;

    public BankAccountRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return dslContext.selectFrom(BANK_ACCOUNT)
            .fetch()
            .map(ArtMapper::mapBankAccount);
    }

    @Override
    public Long addBankAccount(BankAccount bankAccount) {
        return dslContext.insertInto(BANK_ACCOUNT,
                BANK_ACCOUNT.NAME, BANK_ACCOUNT.ACCOUNT_NUMBER, BANK_ACCOUNT.BALANCE)
            .values(bankAccount.getName(), bankAccount.getAccountNumber(), bankAccount.getBalance())
            .returning()
            .fetchOne()
            .getId();
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        dslContext.update(BANK_ACCOUNT)
            .set(BANK_ACCOUNT.NAME, bankAccount.getName())
            .set(BANK_ACCOUNT.ACCOUNT_NUMBER, bankAccount.getAccountNumber())
            .set(BANK_ACCOUNT.BALANCE, bankAccount.getBalance())
            .where(BANK_ACCOUNT.ID.eq(bankAccount.getId()))
            .execute();
    }

    @Override
    public void deleteBankAccount(Long id) {
        dslContext.deleteFrom(BANK_ACCOUNT)
            .where(BANK_ACCOUNT.ID.eq(id))
            .execute();
    }
}