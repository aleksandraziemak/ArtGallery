package com.artgallery.api.painting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPaintingDto {
    private String title;
    private long year;
    private MovementDto movement;
    private StatusDto status;
    private PaintingEstimatedPriceDto paintingEstimatedPrice;
}
