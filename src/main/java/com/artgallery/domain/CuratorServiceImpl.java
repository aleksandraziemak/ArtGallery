package com.artgallery.domain;

import com.artgallery.api.curator.CuratorService;
import com.artgallery.domain.model.Curator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class CuratorServiceImpl implements CuratorService {

    private final CuratorRepository curatorRepository;

    @Override
    public List<Curator> getCurators() {
        return curatorRepository.getCurators();
    }

    @Override
    public void addCurator(Curator curator) {
        curatorRepository.addCurator(curator);
    }

    @Override
    public void editCurator(Curator curator) {
        curatorRepository.updateCurator(curator);
    }

    @Override
    public void deleteCurator(Long id) {
        curatorRepository.deleteCurator(id);
    }
}