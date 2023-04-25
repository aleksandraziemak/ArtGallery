package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.AUTHOR;
import static com.artgallery.dao.db.Tables.COLLECTION_ENTRY;
import static com.artgallery.dao.db.Tables.CURATOR;
import static com.artgallery.dao.db.Tables.PAINTING;

import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CollectionEntryDao {

    private final DSLContext dslContext;

    public List<CollectionEntry> getCollectionEntries() {
        return dslContext.select()
            .from(COLLECTION_ENTRY)
            .leftJoin(PAINTING).on(COLLECTION_ENTRY.PAINTING_ID.eq(PAINTING.ID))
            .leftJoin(AUTHOR).on(COLLECTION_ENTRY.AUTHOR_ID.eq(AUTHOR.ID))
            .leftJoin(CURATOR).on(COLLECTION_ENTRY.CURATOR_ID.eq(CURATOR.ID))
            .fetch()
            .map(record ->
                ArtMapper.mapCollection(record.into(COLLECTION_ENTRY).getId(), record.into(PAINTING), record.into(AUTHOR), record.into(CURATOR))
            );
    }

    public Long addCollectionEntry(Long paintingId, Long authorId, Long curatorId) {
        return dslContext.insertInto(COLLECTION_ENTRY,
                COLLECTION_ENTRY.PAINTING_ID, COLLECTION_ENTRY.AUTHOR_ID, COLLECTION_ENTRY.CURATOR_ID)
            .values(paintingId, authorId, curatorId)
            .returning()
            .fetchOne()
            .getId();
    }

    public void updateCollectionEntry(CollectionEntry collection) {
        dslContext.update(COLLECTION_ENTRY)
            .set(COLLECTION_ENTRY.PAINTING_ID, collection.getPainting().getId())
            .set(COLLECTION_ENTRY.AUTHOR_ID, collection.getAuthor().getId())
            .set(COLLECTION_ENTRY.CURATOR_ID, collection.getCurator().getId())
            .where(COLLECTION_ENTRY.ID.eq(collection.getId()))
            .execute();
    }

    public void deleteCollectionEntry(Long id) {
        dslContext.deleteFrom(COLLECTION_ENTRY)
            .where(COLLECTION_ENTRY.ID.eq(id))
            .execute();
    }
}