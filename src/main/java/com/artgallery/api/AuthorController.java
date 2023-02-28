package com.artgallery.api;

import com.artgallery.domain.ArtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/1/authors")
public class AuthorController {

    private static final ArtService artService = new ArtService();

    @GetMapping
    ResponseEntity<List<AuthorDto>> getAuthors() {
        return ResponseEntity.ok(AuthorMapperDto.authorsDto(artService.getAuthors()));
    }

/*    private static void printMenu() {
        System.out.println("Art Gallery");
        System.out.println("1. Show Art collection");
        System.out.println("2. Show Artists");
        System.out.println("3. Edit Art collection");
        System.out.println("4. Buy Painting");
        System.out.println("5. Sell Painting");
        System.out.println("6. Search Painting");
        System.out.println("7. Bank balance");
        System.out.println("0. Exit");
        System.out.println("Choose option:");
    }*/
}