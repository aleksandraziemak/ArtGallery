package com.artgallery.model;

import java.util.Objects;
import java.util.Optional;

public class Author {
    private String firstName;
    private String secondName;
    private String lastName;
    private String country;

    public Author() {
    }

    public Author(String firstName, String secondName, String lastName, String country) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Optional<String> getSecondName() {
        return Optional.ofNullable(secondName);
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDescription() {
        return getSecondName()
                .map(sn -> String.format("Author: %s %s %s, Country: %s", firstName, sn, lastName, country))
                .orElse(String.format("Author: %s %s, Country: %s", firstName, lastName, country));
/*        if (secondName == null) {
            return String.format("Author: %s %s, Country: %s", firstName, lastName, country);
        } else {
            return String.format("Author: %s %s %s, Country: %s", firstName, secondName, lastName, country);
        }*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country);
    }
}