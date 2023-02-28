package com.artgallery.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Painting {
    private String title;
    private long year;
    private Movement movement;
    private Author author;
    private UUID id;

    public Painting(UUID id) {
        this.id = id;
    }

    public Painting(String title, Movement movement, long year, Author author, UUID id) {
        this.title = title;
        this.year = year;
        this.movement = movement;
        this.author = author;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public long getYear() {
        return this.year;
    }

    public Movement getMovement() {
        return this.movement;
    }

    public UUID getId() {
        return this.id;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getDescription() {
        return String.format("Title: %s, Year: %s, Movement: %s", title, year, movement);
    }

    public String getShortDesctription() {
        return String.format("Title: %s, Author: %s %s", title, author.getFirstName(), author.getLastName());
    }

    public String getFullDescription() {
        return getDescription() + "\n" + author.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painting painting = (Painting) o;
        return Objects.equals(id, painting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}