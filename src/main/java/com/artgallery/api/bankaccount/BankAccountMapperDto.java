package com.artgallery.api.bankaccount;

import com.artgallery.api.CurrencyDto;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Currency;
import java.util.List;

public class BankAccountMapperDto {

    public static List<BankAccountDto> map(List<BankAccount> bankAccount) {
        return bankAccount.stream()
            .map(BankAccountMapperDto::map)
            .toList();
    }

    public static BankAccount map(Long id) {
        return new BankAccount(id);
    }

    public static BankAccountDto map(BankAccount bankAccount) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        bankAccountDto.setId(bankAccount.getId());
        bankAccountDto.setName(bankAccount.getName());
        bankAccountDto.setAccountNumber(bankAccount.getAccountNumber());
        bankAccountDto.setBalance(bankAccount.getBalance());
        bankAccountDto.setCurrency(CurrencyDto.valueOf(bankAccount.getCurrency().name()));
        return bankAccountDto;
    }

    public static BankAccount map(AddBankAccountDto bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(bankAccountDto.getName());
        bankAccount.setAccountNumber(bankAccountDto.getAccountNumber());
        bankAccount.setBalance(bankAccountDto.getBalance());
        bankAccount.setCurrency(Currency.valueOf(bankAccountDto.getCurrency().name()));
        return bankAccount;
    }

    public static BankAccount map(EditBankAccountDto bankAccountDto, Long id) {
        BankAccount bankAccount = new BankAccount(id);
        bankAccount.setName(bankAccountDto.getName());
        bankAccount.setAccountNumber(bankAccountDto.getAccountNumber());
        bankAccount.setBalance(bankAccountDto.getBalance());
        bankAccount.setCurrency(Currency.valueOf(bankAccountDto.getCurrency().name()));
        return bankAccount;
    }
}
