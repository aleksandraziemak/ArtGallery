package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private StatusDto status;
}
