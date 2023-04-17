package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import java.util.List;

public interface AuthorRepository {

    List<Author> getAuthors();

    Long addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Long id);
}