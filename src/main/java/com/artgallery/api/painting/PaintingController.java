package com.artgallery.api.painting;

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
@RequestMapping("/api/1/paintings")
public class PaintingController {

    private final PaintingService paintingService;

    public PaintingController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @GetMapping
    ResponseEntity<List<PaintingDto>> getPaintings() {
        return ResponseEntity.ok(PaintingMapperDto.map(paintingService.getPaintings()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addPainting(@RequestBody AddPaintingDto painting) {
        paintingService.addPainting(PaintingMapperDto.map(painting));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePainting(@PathVariable Long id) {
        paintingService.deletePainting(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Painting> editPainting(@RequestBody EditPaintingDto painting, @PathVariable Long id) {
        paintingService.editPainting(PaintingMapperDto.map(painting, id));
        return ResponseEntity.ok().build();
    }
}