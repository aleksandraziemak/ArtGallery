package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Painting;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ArtService {

    private final ArtRepository repository;

    public ArtService(ArtRepository repository) {
        this.repository = repository;
    }

    public List<Painting> getPaintings() {
        return repository.getPaintings();
    }

    public List<Author> getAuthors() {
        return repository.getPaintings().stream()
            .map(Painting::getAuthor)
            .distinct()
            .toList();
    }

    public void addPainting(Painting painting) {
        repository.addPainting(painting);
    }

    public void editPainting(Painting painting) {
        repository.updatePainting(painting);
    }

    public void deletePainting(UUID id) {
        repository.deletePainting(id);
    }

}