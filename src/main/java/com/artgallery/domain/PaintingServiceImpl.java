package com.artgallery.domain;

import com.artgallery.api.painting.PaintingService;
import com.artgallery.domain.model.Painting;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class PaintingServiceImpl implements PaintingService {

    private final PaintingRepository paintingRepository;

    @Override
    public List<Painting> getPaintings() {
        return paintingRepository.getPaintings();
    }

    @Override
    public void addPainting(Painting painting) {
        paintingRepository.addPainting(painting);
    }

    @Override
    public void editPainting(Painting painting) {
        paintingRepository.updatePainting(painting);
    }

    @Override
    public void deletePainting(Long id) {
        paintingRepository.deletePainting(id);
    }
}