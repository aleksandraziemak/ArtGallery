package com.artgallery.api.bankaccount;

import com.artgallery.domain.model.BankAccount;
import java.util.List;

public interface BankAccountService {

    List<BankAccount> getBankAccounts();

    void addBankAccount(BankAccount bankAccount);

    void editBankAccount(BankAccount bankAccount);

    void deleteBankAccount(Long id);
}
