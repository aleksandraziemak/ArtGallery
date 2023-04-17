package com.artgallery.domain;

import com.artgallery.domain.model.Curator;
import java.util.List;

public interface CuratorRepository {

    List<Curator> getCurators();

    Long addCurator(Curator curator);

    void updateCurator(Curator curator);

    void deleteCurator(Long id);
}