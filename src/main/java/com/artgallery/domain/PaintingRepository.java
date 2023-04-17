package com.artgallery.domain;

import com.artgallery.domain.model.Painting;
import java.util.List;

public interface PaintingRepository {

    List<Painting> getPaintings();

    void addPainting(Painting painting);

    void updatePainting(Painting painting);

    void deletePainting(Long id);
}