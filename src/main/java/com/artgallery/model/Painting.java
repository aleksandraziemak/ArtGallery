package com.artgallery.model;

import java.util.UUID;

public class Painting {
    private String title;
    private int year;
    private String movement;
    private Author author;
    private UUID id;

    public Painting (UUID id) {
        this.id = id;
    }

    public Painting (String title, String movement, Author author, UUID id) {
        this.title = title;
        this.year = year;
        this.movement = movement;
        this.author = author;
        this.id = id;
    }
}