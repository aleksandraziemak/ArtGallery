package com.artgallery.infrastructure;

import com.artgallery.dao.db.tables.records.AuthorRecord;
import com.artgallery.dao.db.tables.records.CuratorRecord;
import com.artgallery.dao.db.tables.records.PaintingRecord;
import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;

public class ArtMapper {

    public static Painting mapPainting(PaintingRecord paintingRecord, AuthorRecord authorRecord, CuratorRecord curatorRecord) {
        Painting painting = new Painting(paintingRecord.getId());
        painting.setMovement(Movement.valueOf(paintingRecord.getMovement()));
        painting.setYear(paintingRecord.getYear());
        painting.setTitle(paintingRecord.getTitle());
        painting.setAuthor(mapAuthor(authorRecord));
        painting.setCurator(mapCurator(curatorRecord));
        painting.setStatus(Status.valueOf(paintingRecord.getStatus()));
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
}