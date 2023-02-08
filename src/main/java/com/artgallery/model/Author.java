package com.artgallery.model;

public class Author {
    private String firstName;
    private String lastName;
    private String country;

    public Author() {
    }

    public Author (String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }
}