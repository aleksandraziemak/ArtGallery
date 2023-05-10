package com.artgallery.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Painting {
    private Long id;
    private String title;
    private Long year;
    private Movement movement;
    private Status status;
    private PaintingEstimatedPrice paintingEstimatedPrice;

    public Painting(Long id) {
        this.id = id;
    }
}