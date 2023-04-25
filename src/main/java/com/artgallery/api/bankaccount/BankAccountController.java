package com.artgallery.api.bankaccount;

import com.artgallery.domain.model.BankAccount;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/bankAccount")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    ResponseEntity<List<BankAccountDto>> getBankAccounts() {
        return ResponseEntity.ok(BankAccountMapperDto.map(bankAccountService.getBankAccounts()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addPainting(@RequestBody AddBankAccountDto bankAccount) {
        bankAccountService.addBankAccount(BankAccountMapperDto.map(bankAccount));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<BankAccount> editBankAccount(@RequestBody EditBankAccountDto bankAccount, @PathVariable Long id) {
        bankAccountService.editBankAccount(BankAccountMapperDto.map(bankAccount, id));
        return ResponseEntity.ok().build();
    }
}