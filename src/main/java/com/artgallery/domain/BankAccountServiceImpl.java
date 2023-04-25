package com.artgallery.domain;

import com.artgallery.api.bankaccount.BankAccountService;
import com.artgallery.domain.model.BankAccount;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.getBankAccounts();
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.addBankAccount(bankAccount);
    }

    @Override
    public void editBankAccount(BankAccount bankAccount) {
        bankAccountRepository.updateBankAccount(bankAccount);
    }

    @Override
    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteBankAccount(id);
    }
}