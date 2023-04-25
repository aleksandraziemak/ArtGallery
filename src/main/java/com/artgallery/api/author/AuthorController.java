package com.artgallery.api.author;

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

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    ResponseEntity<List<AuthorDto>> getAuthors() {
        return ResponseEntity.ok(AuthorMapperDto.map(authorService.getAuthors()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addAuthor(@RequestBody AddAuthorDto author) {
        authorService.addAuthor(AuthorMapperDto.map(author));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Author> editAuthor(@RequestBody EditAuthorDto author, @PathVariable Long id) {
        authorService.editAuthor(AuthorMapperDto.map(author, id));
        return ResponseEntity.ok().build();
    }
}