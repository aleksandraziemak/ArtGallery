package com.artgallery.domain.model;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Author {
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String country;

    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }

    public Optional<String> getSecondName() {
        return Optional.ofNullable(secondName);
    }
}