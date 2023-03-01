package com.artgallery.api;

import java.util.UUID;

public class EditPaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private EditAuthorDto author;
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

    public EditAuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(EditAuthorDto author) {
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
