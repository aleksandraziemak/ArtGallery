package com.artgallery.infrastructure;

import com.artgallery.domain.PaintingRepository;
import com.artgallery.domain.model.Painting;
import com.artgallery.infrastructure.dao.PaintingDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PaintingRepositoryImpl implements PaintingRepository {

    private final PaintingDao paintingDao;

    @Override
    public List<Painting> getPaintings() {
        return paintingDao.getPaintings();
    }

    @Override
    public Painting find(Long id) {
        return paintingDao.find(id);
    }

    @Override
    public void addPainting(Painting painting) {
        paintingDao.addPainting(painting);
    }

    @Override
    public void updatePainting(Painting painting) {
        paintingDao.updatePainting(painting);
    }

    @Override
    public void deletePainting(Long id) {
        paintingDao.deletePainting(id);
    }
}