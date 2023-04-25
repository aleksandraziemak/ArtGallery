package com.artgallery.domain;

import com.artgallery.domain.model.BankAccount;
import java.util.List;

public interface BankAccountRepository {

    List<BankAccount> getBankAccounts();

    BankAccount find(Long id);

    Long addBankAccount(BankAccount bankAccount);

    void updateBankAccount(BankAccount bankAccount);

    void deleteBankAccount(Long id);
}