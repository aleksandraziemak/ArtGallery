package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPaintingDto {
    private String title;
    private Long year;
    private MovementDto movement;
    private StatusDto status;
}
