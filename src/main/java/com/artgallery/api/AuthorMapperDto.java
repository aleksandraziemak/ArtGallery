package com.artgallery.api;

import com.artgallery.domain.model.Author;
import java.util.List;

public class AuthorMapperDto {

    public static List<AuthorDto> map(List<Author> authors) {
        return authors.stream()
            .map(AuthorMapperDto::map)
            .toList();
    }

    public static AuthorDto map(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setSecondName(author.getSecondName().orElse(null));
        authorDto.setLastName(author.getLastName());
        authorDto.setCountry(author.getCountry());
        return authorDto;
    }

    public static Author map(Long id) {
        return new Author(id);
    }

    public static Author map(AddAuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setSecondName(authorDto.getSecondName());
        author.setLastName(authorDto.getLastName());
        author.setCountry(authorDto.getCountry());
        return author;
    }

    public static Author map(EditAuthorDto authorDto, Long id) {
        Author author = new Author(id);
        author.setFirstName(authorDto.getFirstName());
        author.setSecondName(authorDto.getSecondName());
        author.setLastName(authorDto.getLastName());
        author.setCountry(authorDto.getCountry());
        return author;
    }
}
