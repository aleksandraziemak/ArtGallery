package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.PAINTING;

import com.artgallery.domain.model.Painting;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaintingDao {

    private final DSLContext dslContext;

    public List<Painting> getPaintings() {
        return dslContext.selectFrom(PAINTING)
            .fetch()
            .map(ArtMapper::mapPainting);
    }

    public Painting find(Long id) {
        return dslContext.selectFrom(PAINTING)
            .where(PAINTING.ID.eq(id))
            .fetchOptional()
            .map(ArtMapper::mapPainting)
            .orElseThrow(() -> new IllegalStateException(String.format("Painting not found for ID %s", id)));
    }

    public void addPainting(Painting painting) {
        dslContext.insertInto(PAINTING,
                PAINTING.TITLE, PAINTING.YEAR, PAINTING.MOVEMENT, PAINTING.STATUS)
            .values(painting.getTitle(), painting.getYear(), painting.getMovement().name(), painting.getStatus().name())
            .execute();
    }

    public void updatePainting(Painting painting) {
        dslContext.update(PAINTING)
            .set(PAINTING.TITLE, painting.getTitle())
            .set(PAINTING.YEAR, painting.getYear())
            .set(PAINTING.MOVEMENT, painting.getMovement().name())
            .set(PAINTING.STATUS, painting.getStatus().name())
            .where(PAINTING.ID.eq(painting.getId()))
            .execute();
    }

    public void deletePainting(Long id) {
        dslContext.deleteFrom(PAINTING)
            .where(PAINTING.ID.eq(id))
            .execute();
    }
}