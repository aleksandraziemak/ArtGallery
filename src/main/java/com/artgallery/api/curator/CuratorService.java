package com.artgallery.api.curator;

import com.artgallery.domain.model.Curator;
import java.util.List;

public interface CuratorService {

    List<Curator> getCurators();

    void addCurator(Curator curator);

    void editCurator(Curator curator);

    void deleteCurator(Long id);
}
