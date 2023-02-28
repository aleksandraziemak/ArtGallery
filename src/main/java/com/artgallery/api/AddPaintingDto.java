package com.artgallery.api;

public class AddPaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private AddAuthorDto author;

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

    public AddAuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AddAuthorDto author) {
        this.author = author;
    }
}
