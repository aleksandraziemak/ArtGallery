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
@RequestMapping("/api/1/client")
public class ClientController {

    private final ArtService artService;

    public ClientController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(ClientMapperDto.map(artService.getClients()));
    }

    @PostMapping("/add")
    ResponseEntity<Void> addClient(@RequestBody AddClientDto client) {
        artService.addClient(ClientMapperDto.map(client));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        artService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    ResponseEntity<Painting> editClient(@RequestBody EditClientDto client, @PathVariable Long id) {
        artService.editClient(ClientMapperDto.map(client, id));
        return ResponseEntity.ok().build();
    }
}