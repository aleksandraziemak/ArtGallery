package com.artgallery.api.author;

import com.artgallery.domain.model.Author;
import java.util.List;

public interface AuthorService {

    List<Author> getAuthors();

    void addAuthor(Author author);

    void editAuthor(Author author);

    void deleteAuthor(Long id);
}
