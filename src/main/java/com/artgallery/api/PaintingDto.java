package com.artgallery.api;

import java.util.UUID;

public class PaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private AuthorDto author;
    private UUID id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public MovementDto getMovement() {
        return movement;
    }

    public void setMovement(MovementDto movement) {
        this.movement = movement;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
