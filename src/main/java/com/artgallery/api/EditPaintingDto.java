package com.artgallery.api;

public class EditPaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private StatusDto status;
    private Long id;
    private AuthorDto author;
    private CuratorDto curator;

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

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public CuratorDto getCurator() {
        return curator;
    }

    public void setCurator(CuratorDto curator) {
        this.curator = curator;
    }
}
