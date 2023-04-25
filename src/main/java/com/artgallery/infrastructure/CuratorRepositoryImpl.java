package com.artgallery.infrastructure;

import com.artgallery.domain.CuratorRepository;
import com.artgallery.domain.model.Curator;
import com.artgallery.infrastructure.dao.CuratorDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CuratorRepositoryImpl implements CuratorRepository {

    private final CuratorDao curatorDao;

    @Override
    public List<Curator> getCurators() {
        return curatorDao.getCurators();
    }

    @Override
    public Long addCurator(Curator curator) {
        return curatorDao.addCurator(curator);
    }

    @Override
    public void updateCurator(Curator curator) {
        curatorDao.updateCurator(curator);
    }

    @Override
    public void deleteCurator(Long id) {
        curatorDao.deleteCurator(id);
    }
}