package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Painting;
import java.util.List;

public interface ArtRepository {

    List<CollectionEntry> getCollection();

    List<Painting> getPaintings();

    List<Author> getAuthors();

    List<Curator> getCurators();

    void addPainting(Painting painting);

    Long addAuthor(Author author);

    Long addCurator(Curator curator);

    void updatePainting(Painting painting);

    void deletePainting(Long id);
}