package com.artgallery;

import com.artgallery.model.Painting;

import java.util.List;

public interface ArtRepository {

    List<Painting> getPaintings();

    void addPainting(Painting painting);

    void updatePainting(Painting painting);

    void sellPainting(Painting painting);
}