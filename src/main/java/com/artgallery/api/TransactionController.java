package com.artgallery.api;

import com.artgallery.domain.ArtService;
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
@RequestMapping("/api/1/transaction")
public class TransactionController {

    private final ArtService artService;

    public TransactionController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<TransactionDto>> getTransactions() {
        return ResponseEntity.ok(TransactionMapperDto.map(artService.getTransactions()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addTransaction(@RequestBody AddTransactionDto transaction) {
        artService.addTransaction(TransactionMapperDto.map(transaction));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        artService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Painting> editTransaction(@RequestBody EditTransactionDto transaction, @PathVariable Long id) {
        artService.editTransaction(TransactionMapperDto.map(transaction, id));
        return ResponseEntity.ok().build();
    }
}