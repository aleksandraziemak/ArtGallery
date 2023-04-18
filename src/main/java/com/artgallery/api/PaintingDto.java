package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private Long id;
    private StatusDto status;
}
