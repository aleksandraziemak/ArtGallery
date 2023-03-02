package com.artgallery.api;

import com.artgallery.domain.ArtService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/authors")
public class AuthorController {

    private static final ArtService artService = new ArtService();

    @GetMapping
    ResponseEntity<List<AuthorDto>> getAuthors() {
        return ResponseEntity.ok(AuthorMapperDto.map(artService.getAuthors()));
    }
}