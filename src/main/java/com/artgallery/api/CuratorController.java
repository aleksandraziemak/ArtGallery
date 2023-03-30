package com.artgallery.api;

import com.artgallery.domain.ArtService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/curator")
public class CuratorController {

    private final ArtService artService;

    public CuratorController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<CuratorDto>> getCurators() {
        return ResponseEntity.ok(CuratorMapperDto.map(artService.getCurators()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addCurator(@RequestBody AddCuratorDto curator) {
        artService.addCurator(CuratorMapperDto.map(curator));
        return ResponseEntity.ok().build();
    }
}