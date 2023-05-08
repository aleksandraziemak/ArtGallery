package com.artgallery.api.collectionentry;

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
@RequestMapping("/api/1/collectionEntry")
public class CollectionEntryController {

    private final CollectionEntryService collectionEntryService;

    public CollectionEntryController(CollectionEntryService collectionEntryService) {
        this.collectionEntryService = collectionEntryService;
    }

    @GetMapping
    ResponseEntity<List<CollectionEntryDto>> getCollectionEntries() {
        return ResponseEntity.ok(CollectionEntryMapperDto.map(collectionEntryService.getCollectionEntries()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addCollectionEntry(@RequestBody AddCollectionEntryDto collection) {
        collectionEntryService.addCollectionEntry(collection.getPaintingId(), collection.getAuthorId(), collection.getCuratorId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCollectionEntry(@PathVariable Long id) {
        collectionEntryService.deleteCollectionEntry(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Painting> editCollectionEntry(@RequestBody EditCollectionEntryDto collection, @PathVariable Long id) {
        collectionEntryService.editCollectionEntry(CollectionEntryMapperDto.map(collection, id));
        return ResponseEntity.ok().build();
    }
}