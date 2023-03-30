package com.artgallery.api;

public class AddPaintingDto {
    private String title;
    private Long year;
    private MovementDto movement;
    private StatusDto status;
    private AddAuthorDto author;
    private AddCuratorDto curator;

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

    public MovementDto getMovement() {
        return movement;
    }

    public void setMovement(MovementDto movement) {
        this.movement = movement;
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public AddAuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AddAuthorDto author) {
        this.author = author;
    }

    public AddCuratorDto getCurator() {
        return curator;
    }

    public void setCurator(AddCuratorDto curator) {
        this.curator = curator;
    }
}
