package com.artgallery.api.painting;

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
