package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.AUTHOR;
import static com.artgallery.dao.db.Tables.COLLECTION_ENTRY;
import static com.artgallery.dao.db.Tables.CURATOR;
import static com.artgallery.dao.db.Tables.PAINTING;

import com.artgallery.dao.db.tables.records.AuthorRecord;
import com.artgallery.dao.db.tables.records.CuratorRecord;
import com.artgallery.domain.ArtRepository;
import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Painting;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ArtRepositoryDatabase implements ArtRepository {

    private final DSLContext dslContext;

    public ArtRepositoryDatabase(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<CollectionEntry> getCollection() {
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

    @Override
    public List<Painting> getPaintings() {
        return dslContext.selectFrom(PAINTING)
            .fetch()
            .map(ArtMapper::mapPainting);
    }

    private AuthorRecord findAuthor(Long id) {
        return dslContext.selectFrom(AUTHOR)
            .where(AUTHOR.ID.eq(id))
            .fetchOne();
    }

    private CuratorRecord findCurator(Long id) {
        return dslContext.selectFrom(CURATOR)
            .where(CURATOR.ID.eq(id))
            .fetchOne();
    }

    @Override
    public List<Author> getAuthors() {
        return dslContext.selectFrom(AUTHOR)
            .fetch()
            .map(ArtMapper::mapAuthor);
    }

    @Override
    public List<Curator> getCurators() {
        return dslContext.selectFrom(CURATOR)
            .fetch()
            .map(ArtMapper::mapCurator);
    }

    @Override
    public void addPainting(Painting painting) {
        dslContext.insertInto(PAINTING,
                PAINTING.TITLE, PAINTING.YEAR, PAINTING.MOVEMENT, PAINTING.STATUS)
            .values(painting.getTitle(), painting.getYear(), painting.getMovement().name(), painting.getStatus().name())
            .execute();
    }

    @Override
    public Long addAuthor(Author author) {
        return dslContext.insertInto(AUTHOR,
                AUTHOR.FIRST_NAME, AUTHOR.SECOND_NAME, AUTHOR.LAST_NAME, AUTHOR.COUNTRY)
            .values(author.getFirstName(), author.getSecondName().orElse(null), author.getLastName(), author.getCountry())
            .returning()
            .fetchOne()
            .getId();
    }

    @Override
    public Long addCurator(Curator curator) {
        return dslContext.insertInto(CURATOR,
                CURATOR.FIRST_NAME, CURATOR.LAST_NAME, CURATOR.SALARY)
            .values(curator.getFirstName(), curator.getLastName(), curator.getSalary())
            .returning()
            .fetchOne()
            .getId();
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