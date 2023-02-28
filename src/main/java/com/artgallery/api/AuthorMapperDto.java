package com.artgallery.api;

import com.artgallery.domain.model.Author;

import java.util.List;

public class AuthorMapperDto {

    public static List<AuthorDto> authorsDto(List<Author> authors) {
        return authors.stream()
                .map(AuthorMapperDto::mapAuthors)
                .toList();
    }

    public static AuthorDto mapAuthors(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(author.getFirstName());
        authorDto.setSecondName(author.getSecondName().orElse(null));
        authorDto.setLastName(author.getLastName());
        authorDto.setCountry(author.getCountry());
        return authorDto;
    }

    public static Author map(AddAuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setSecondName(authorDto.getSecondName());
        author.setLastName(authorDto.getLastName());
        author.setCountry(authorDto.getCountry());
        return author;
    }
}
