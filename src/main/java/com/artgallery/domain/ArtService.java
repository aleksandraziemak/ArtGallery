package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Painting;
import com.artgallery.infrastructure.ArtRepositoryDatabase;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArtService {

    private final ArtRepository repository;

    public ArtService(ArtRepositoryDatabase repository) {
        this.repository = repository;
    }

    public List<CollectionEntry> getCollection() {
        return repository.getCollection();
    }

    public List<Painting> getPaintings() {
        return repository.getPaintings();
    }

    public List<Author> getAuthors() {
        return repository.getAuthors();
    }

    public List<Curator> getCurators() {
        return repository.getCurators();
    }

    public void addPainting(Painting painting) {
        repository.addPainting(painting);
    }

    public void addAuthor(Author author) {
        repository.addAuthor(author);
    }

    public void addCurator(Curator curator) {
        repository.addCurator(curator);
    }

    public void editPainting(Painting painting) {
        repository.updatePainting(painting);
    }

    public void deletePainting(Long id) {
        repository.deletePainting(id);
    }
}