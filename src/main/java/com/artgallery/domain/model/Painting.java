package com.artgallery.domain.model;

import java.util.Objects;

public class Painting {
    private Long id;
    private String title;
    private Long year;
    private Movement movement;
    private Author author;
    private Curator curator;
    private Status status;

    public Painting() {
    }

    public Painting(Long id) {
        this.id = id;
    }

    public Painting(String title, Movement movement, long year, Author author, Long id, Status status) {
        this.title = title;
        this.year = year;
        this.movement = movement;
        this.status = status;
        this.author = author;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Painting painting = (Painting) o;
        return Objects.equals(id, painting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}