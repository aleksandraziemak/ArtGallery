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
@RequestMapping("/api/1/collection")
public class CollectionEntryController {

    private final ArtService artService;

    public CollectionEntryController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<CollectionEntryDto>> getCollectionEntries() {
        return ResponseEntity.ok(CollectionEntryMapperDto.map(artService.getCollectionEntries()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addCollectionEntry(@RequestBody AddCollectionEntryDto collection) {
        artService.addCollectionEntry(CollectionEntryMapperDto.map(collection));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCollectionEntry(@PathVariable Long id) {
        artService.deleteCollectionEntry(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Painting> editCollectionEntry(@RequestBody EditCollectionEntryDto collection, @PathVariable Long id) {
        artService.editCollectionEntry(CollectionEntryMapperDto.map(collection, id));
        return ResponseEntity.ok().build();
    }
}