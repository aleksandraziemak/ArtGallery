package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Painting;
import java.util.List;

public interface CuratorRepository {

    List<Curator> getCurators();

    Long addCurator(Curator curator);

    void updateCurator(Curator curator);

    void deleteCurator(Long id);
}