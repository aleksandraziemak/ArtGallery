package com.artgallery.infrastructure;

import com.artgallery.domain.BankAccountRepository;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.infrastructure.dao.BankAccountDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BankAccountRepositoryImpl implements BankAccountRepository {

    private final BankAccountDao bankAccountDao;

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountDao.getBankAccounts();
    }

    @Override
    public BankAccount find(Long id) {
        return bankAccountDao.find(id);
    }

    @Override
    public Long addBankAccount(BankAccount bankAccount) {
        return bankAccountDao.addBankAccount(bankAccount);
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        bankAccountDao.updateBankAccount(bankAccount);
    }

    @Override
    public void deleteBankAccount(Long id) {
        bankAccountDao.deleteBankAccount(id);
    }
}