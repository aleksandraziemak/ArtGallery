package com.artgallery.api;

import com.artgallery.domain.ArtService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/collection")
public class CollectionController {

    private final ArtService artService;

    public CollectionController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<CollectionEntryDto>> getCollection() {
        return ResponseEntity.ok(CollectionMapperDto.map(artService.getCollection()));
    }

}