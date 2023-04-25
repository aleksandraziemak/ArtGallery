package com.artgallery.api.painting;

import com.artgallery.domain.model.Painting;
import java.util.List;

public interface PaintingService {

    List<Painting> getPaintings();

    void addPainting(Painting painting);

    void editPainting(Painting painting);

    void deletePainting(Long id);
}
