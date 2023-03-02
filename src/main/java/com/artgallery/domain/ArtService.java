package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Painting;
import com.artgallery.infrastructure.ArtRepositoryJson;
import java.util.List;
import java.util.UUID;

public class ArtService {

    private final ArtRepository repository = new ArtRepositoryJson();

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