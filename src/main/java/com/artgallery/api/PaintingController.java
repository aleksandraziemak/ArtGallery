package com.artgallery.api;

import com.artgallery.domain.ArtService;
import com.artgallery.domain.model.Painting;
import java.util.List;
import java.util.UUID;
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
@RequestMapping("/api/1/paintings")
public class PaintingController {

    private final ArtService artService;

    public PaintingController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<PaintingDto>> getPaintings() {
        return ResponseEntity.ok(PaintingMapperDto.map(artService.getPaintings()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addPainting(@RequestBody AddPaintingDto painting) {
        artService.addPainting(PaintingMapperDto.map(painting));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id) {
        artService.deletePainting(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/edit")
    ResponseEntity<Painting> editPainting(@RequestBody EditPaintingDto painting) {
        artService.editPainting(PaintingMapperDto.map(painting));
        return ResponseEntity.ok().build();
    }
}