package com.artgallery.domain;

import com.artgallery.domain.model.Painting;

import java.util.List;
import java.util.UUID;

public interface ArtRepository {

    List<Painting> getPaintings();

    void addPainting(Painting painting);

    void updatePainting(Painting painting);

    void deletePainting(UUID id);
}