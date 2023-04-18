package com.artgallery.api;

import com.artgallery.domain.ArtService;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Painting;
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

    private final ArtService artService;

    public BankAccountController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<BankAccountDto>> getBankAccounts() {
        return ResponseEntity.ok(BankAccountMapperDto.map(artService.getBankAccounts()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addPainting(@RequestBody AddBankAccountDto bankAccount) {
        artService.addBankAccount(BankAccountMapperDto.map(bankAccount));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        artService.deleteBankAccount(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<BankAccount> editBankAccount(@RequestBody EditBankAccountDto bankAccount, @PathVariable Long id) {
        artService.editBankAccount(BankAccountMapperDto.map(bankAccount, id));
        return ResponseEntity.ok().build();
    }
}