package com.artgallery.domain;

import com.artgallery.api.author.AuthorService;
import com.artgallery.domain.model.Author;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthors() {
        return authorRepository.getAuthors();
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.addAuthor(author);
    }

    @Override
    public void editAuthor(Author author) {
        authorRepository.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthor(id);
    }
}