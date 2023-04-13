package com.artgallery.api;

import com.artgallery.domain.ArtService;
import com.artgallery.domain.model.Author;
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
@RequestMapping("/api/1/author")
public class AuthorController {

    private final ArtService artService;

    public AuthorController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<AuthorDto>> getAuthors() {
        return ResponseEntity.ok(AuthorMapperDto.map(artService.getAuthors()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addAuthor(@RequestBody AddAuthorDto author) {
        artService.addAuthor(AuthorMapperDto.map(author));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        artService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Author> editAuthor(@RequestBody EditAuthorDto author, @PathVariable Long id) {
        artService.editAuthor(AuthorMapperDto.map(author, id));
        return ResponseEntity.ok().build();
    }
}