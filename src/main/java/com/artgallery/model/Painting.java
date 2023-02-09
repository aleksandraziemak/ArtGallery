package com.artgallery.model;

import java.util.UUID;

public class Painting {
    private String title;
    private long year;
    private String movement;
    private Author author;
    private UUID id;

    public Painting (UUID id) {
        this.id = id;
    }

    public Painting (String title, String movement, long year, Author author, UUID id) {
        this.title = title;
        this.year = year;
        this.movement = movement;
        this.author = author;
        this.id = id;
    }

    public void setTitle() {
        this.title = title;
    }

    public void setYear() {
        this.year = year;
    }

    public void setMovement() {
        this.movement = movement;
    }

    public void setAuthor() {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public long getYear() {
        return this.year;
    }

    public String getMovement() {
        return this.movement;
    }

    public UUID getId() {
        return  this.id;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getDescription() {
        return String.format("Title: %s, Year: %s, Movement: %s",title, year, movement);
    }


    public String getFullDescription() {
        return getDescription() + "\n" + author.getDescription();
    }
}