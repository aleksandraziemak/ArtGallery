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

    public void setFirstName() {
        this.firstName = firstName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public void setCountry() {
        this.country = country;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return  this.lastName;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDescription() {
        return String.format("Author: %s %s, Country: %s", firstName, lastName, country);
    }
}