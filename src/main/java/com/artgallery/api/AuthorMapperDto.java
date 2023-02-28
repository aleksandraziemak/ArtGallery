package com.artgallery.api;

import com.artgallery.domain.model.Author;

public class AuthorMapperDto {
    public static AuthorDto map(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(author.getFirstName());
        authorDto.setSecondName(author.getSecondName().orElse(null));
        authorDto.setLastName(author.getLastName());
        authorDto.setCountry(author.getCountry());
        return authorDto;
    }
}
