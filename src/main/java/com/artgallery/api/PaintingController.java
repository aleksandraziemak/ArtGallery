package com.artgallery.api;

import com.artgallery.domain.ArtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/1/paintings")
public class PaintingController {

    private static final ArtService artService = new ArtService();

    @GetMapping
    ResponseEntity<List<PaintingDto>> getPaintings() {
        return ResponseEntity.ok(PaintingMapperDto.paintingsDto(artService.getPaintings()));
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