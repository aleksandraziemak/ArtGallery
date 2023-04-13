package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.AUTHOR;

import com.artgallery.domain.AuthorRepository;
import com.artgallery.domain.model.Author;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private final DSLContext dslContext;

    public AuthorRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Author> getAuthors() {
        return dslContext.selectFrom(AUTHOR)
            .fetch()
            .map(ArtMapper::mapAuthor);
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
    public void updateAuthor(Author author) {
        dslContext.update(AUTHOR)
            .set(AUTHOR.FIRST_NAME, author.getFirstName())
            .set(AUTHOR.SECOND_NAME, author.getSecondName().orElse(null))
            .set(AUTHOR.LAST_NAME, author.getLastName())
            .set(AUTHOR.COUNTRY, author.getCountry())
            .where(AUTHOR.ID.eq(author.getId()))
            .execute();
    }

    @Override
    public void deleteAuthor(Long id) {
        dslContext.deleteFrom(AUTHOR)
            .where(AUTHOR.ID.eq(id))
            .execute();
    }
}