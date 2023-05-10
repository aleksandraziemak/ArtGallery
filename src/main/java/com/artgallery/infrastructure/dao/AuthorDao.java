package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.AUTHOR;

import com.artgallery.domain.model.Author;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthorDao {

    private final DSLContext dslContext;

    public List<Author> getAuthors() {
        return dslContext.selectFrom(AUTHOR)
            .fetch()
            .map(ArtMapper::mapAuthor);
    }

    public Long addAuthor(Author author) {
        return dslContext.insertInto(AUTHOR)
            .set(AUTHOR.FIRST_NAME, author.getFirstName())
            .set(AUTHOR.SECOND_NAME, author.getSecondName().orElse(null))
            .set(AUTHOR.LAST_NAME, author.getLastName())
            .set(AUTHOR.COUNTRY, author.getCountry())
            .returning()
            .fetchOne()
            .getId();
    }

    public void updateAuthor(Author author) {
        dslContext.update(AUTHOR)
            .set(AUTHOR.FIRST_NAME, author.getFirstName())
            .set(AUTHOR.SECOND_NAME, author.getSecondName().orElse(null))
            .set(AUTHOR.LAST_NAME, author.getLastName())
            .set(AUTHOR.COUNTRY, author.getCountry())
            .where(AUTHOR.ID.eq(author.getId()))
            .execute();
    }

    public void deleteAuthor(Long id) {
        dslContext.deleteFrom(AUTHOR)
            .where(AUTHOR.ID.eq(id))
            .execute();
    }
}