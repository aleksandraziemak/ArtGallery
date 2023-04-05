package com.artgallery.infrastructure;

import com.artgallery.dao.db.tables.records.AuthorRecord;
import com.artgallery.dao.db.tables.records.CuratorRecord;
import com.artgallery.dao.db.tables.records.PaintingRecord;
import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;

public class ArtMapper {

    public static Painting mapPainting(PaintingRecord record) {
        Painting painting = new Painting(record.getId());
        painting.setMovement(Movement.valueOf(record.getMovement()));
        painting.setYear(record.getYear());
        painting.setTitle(record.getTitle());
        painting.setStatus(Status.valueOf(record.getStatus()));
        return painting;
    }

    public static Author mapAuthor(AuthorRecord record) {
        Author author = new Author(record.getId());
        author.setFirstName(record.getFirstName());
        author.setSecondName(record.getSecondName());
        author.setLastName(record.getLastName());
        author.setCountry(record.getCountry());
        return author;
    }

    public static Curator mapCurator(CuratorRecord record) {
        Curator curator = new Curator(record.getId());
        curator.setFirstName(record.getFirstName());
        curator.setLastName(record.getLastName());
        curator.setSalary(record.getSalary());
        return curator;
    }

    public static CollectionEntry mapCollection(Long collectionEntryId,
                                                PaintingRecord paintingRecord,
                                                AuthorRecord authorRecord,
                                                CuratorRecord curatorRecord) {
        CollectionEntry collectionEntry = new CollectionEntry(collectionEntryId);
        collectionEntry.setPainting(mapPainting(paintingRecord));
        collectionEntry.setAuthor(mapAuthor(authorRecord));
        collectionEntry.setCurator(mapCurator(curatorRecord));
        return collectionEntry;
    }
}