package com.artgallery.domain;

import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Curator;
import java.util.List;

public interface BankAccountRepository {

    List<BankAccount> getBankAccounts();

    Long addBankAccount(BankAccount bankAccount);

    void updateBankAccount(BankAccount bankAccount);

    void deleteBankAccount(Long id);
}