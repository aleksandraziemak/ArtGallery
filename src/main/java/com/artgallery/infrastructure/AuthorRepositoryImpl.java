package com.artgallery.infrastructure;

import com.artgallery.domain.AuthorRepository;
import com.artgallery.domain.model.Author;
import com.artgallery.infrastructure.dao.AuthorDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDao authorDao;

    @Override
    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }

    @Override
    public Long addAuthor(Author author) {
        return authorDao.addAuthor(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorDao.deleteAuthor(id);
    }
}