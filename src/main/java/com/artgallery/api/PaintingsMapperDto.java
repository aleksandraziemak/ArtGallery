package com.artgallery.api;

import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.util.UuidGeneratorUtil;

import java.util.List;

public class PaintingsMapperDto {

    public static List<PaintingDto> paintingsDto(List<Painting> paintings) {
        return paintings.stream()
                .map(PaintingsMapperDto::mapDto)
                .toList();
    }

    private static PaintingDto mapDto(Painting painting) {
        PaintingDto paintingDto = new PaintingDto();
        paintingDto.setAuthor(AuthorMapperDto.mapDto(painting.getAuthor()));
        paintingDto.setTitle(painting.getTitle());
        paintingDto.setYear(painting.getYear());
        paintingDto.setMovement(MovementDto.valueOf(painting.getMovement().name()));
        return paintingDto;
    }

    public static Painting map(AddPaintingDto paintingDto) {
        Painting painting = new Painting(UuidGeneratorUtil.uuidGenerate());
        painting.setAuthor(AuthorMapperDto.map(paintingDto.getAuthor()));
        painting.setTitle(paintingDto.getTitle());
        painting.setYear(paintingDto.getYear());
        painting.setMovement(Movement.valueOf(paintingDto.getMovement().name()));
        return painting;
    }
}