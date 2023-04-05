package com.artgallery.api;

import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;
import java.util.List;

public class PaintingMapperDto {

    public static List<PaintingDto> map(List<Painting> paintings) {
        return paintings.stream()
            .map(PaintingMapperDto::map)
            .toList();
    }

    public static PaintingDto map(Painting painting) {
        PaintingDto paintingDto = new PaintingDto();
        paintingDto.setId(painting.getId());
        paintingDto.setTitle(painting.getTitle());
        paintingDto.setYear(painting.getYear());
        paintingDto.setMovement(MovementDto.valueOf(painting.getMovement().name()));
        paintingDto.setStatus(StatusDto.valueOf(painting.getStatus().name()));
        return paintingDto;
    }

    public static Painting map(AddPaintingDto paintingDto) {
        Painting painting = new Painting();
        painting.setTitle(paintingDto.getTitle());
        painting.setYear(paintingDto.getYear());
        painting.setMovement(Movement.valueOf(paintingDto.getMovement().name()));
        painting.setStatus(Status.valueOf(paintingDto.getStatus().name()));
        return painting;
    }

    public static Painting map(EditPaintingDto paintingDto, Long id) {
        Painting painting = new Painting(id);
        painting.setTitle(paintingDto.getTitle());
        painting.setYear(paintingDto.getYear());
        painting.setMovement(Movement.valueOf(paintingDto.getMovement().name()));
        painting.setStatus(Status.valueOf(paintingDto.getStatus().name()));
        return painting;
    }
}