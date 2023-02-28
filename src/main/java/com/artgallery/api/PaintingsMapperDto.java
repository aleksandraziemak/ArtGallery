package com.artgallery.api;

import com.artgallery.domain.model.Painting;

import java.util.List;

public class PaintingsMapperDto {

    public static List<PaintingDto> paintingsDto(List<Painting> paintings) {
        return paintings.stream()
                .map(PaintingsMapperDto::mapDto)
                .toList();
    }

    private static PaintingDto mapDto(Painting painting) {
        PaintingDto paintingDto = new PaintingDto();
        paintingDto.setAuthor(AuthorMapperDto.map(painting.getAuthor()));
        paintingDto.setTitle(painting.getTitle());
        paintingDto.setYear(painting.getYear());
        paintingDto.setMovement(MovementDto.valueOf(painting.getMovement().name()));
        return paintingDto;
    }
}
