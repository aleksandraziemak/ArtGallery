package com.artgallery.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Painting {
    private Long id;
    private String title;
    private Long year;
    private Movement movement;
    private Status status;

    public Painting() {
    }

    public Painting(Long id) {
        this.id = id;
    }
}