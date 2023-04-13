package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.PAINTING;

import com.artgallery.domain.PaintingRepository;
import com.artgallery.domain.model.Painting;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class PaintingRepositoryImpl implements PaintingRepository {

    private final DSLContext dslContext;

    public PaintingRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Painting> getPaintings() {
        return dslContext.selectFrom(PAINTING)
            .fetch()
            .map(ArtMapper::mapPainting);
    }

    @Override
    public void addPainting(Painting painting) {
        dslContext.insertInto(PAINTING,
                PAINTING.TITLE, PAINTING.YEAR, PAINTING.MOVEMENT, PAINTING.STATUS)
            .values(painting.getTitle(), painting.getYear(), painting.getMovement().name(), painting.getStatus().name())
            .execute();
    }

    @Override
    public void updatePainting(Painting painting) {
        dslContext.update(PAINTING)
            .set(PAINTING.TITLE, painting.getTitle())
            .set(PAINTING.YEAR, painting.getYear())
            .set(PAINTING.MOVEMENT, painting.getMovement().name())
            .set(PAINTING.STATUS, painting.getStatus().name())
            .where(PAINTING.ID.eq(painting.getId()))
            .execute();
    }

    @Override
    public void deletePainting(Long id) {
        dslContext.deleteFrom(PAINTING)
            .where(PAINTING.ID.eq(id))
            .execute();
    }
}