package com.artgallery.api.curator;

import com.artgallery.domain.model.Curator;
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
@RequestMapping("/api/1/curator")
public class CuratorController {

    private final CuratorService curatorService;

    public CuratorController(CuratorService curatorService) {
        this.curatorService = curatorService;
    }

    @GetMapping
    ResponseEntity<List<CuratorDto>> getCurators() {
        return ResponseEntity.ok(CuratorMapperDto.map(curatorService.getCurators()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addCurator(@RequestBody AddCuratorDto curator) {
        curatorService.addCurator(CuratorMapperDto.map(curator));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCurator(@PathVariable Long id) {
        curatorService.deleteCurator(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Curator> editCurator(@RequestBody EditCuratorDto curator, @PathVariable Long id) {
        curatorService.editCurator(CuratorMapperDto.map(curator, id));
        return ResponseEntity.ok().build();
    }
}