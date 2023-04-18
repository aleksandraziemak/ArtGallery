package com.artgallery.domain.model;

import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country);
    }
}