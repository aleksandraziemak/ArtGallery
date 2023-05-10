package com.artgallery.api.painting;

import com.artgallery.api.CurrencyDto;
import com.artgallery.domain.model.Currency;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.PaintingEstimatedPrice;
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
        paintingDto.setPaintingEstimatedPrice(map(painting.getPaintingEstimatedPrice()));
        return paintingDto;
    }

    public static Painting map(Long id) {
        return new Painting(id);
    }

    public static Painting map(AddPaintingDto paintingDto) {
        Painting painting = new Painting();
        painting.setTitle(paintingDto.getTitle());
        painting.setYear(paintingDto.getYear());
        painting.setMovement(Movement.valueOf(paintingDto.getMovement().name()));
        painting.setStatus(Status.valueOf(paintingDto.getStatus().name()));
        painting.setPaintingEstimatedPrice(map(paintingDto.getPaintingEstimatedPrice()));
        return painting;
    }

    public static Painting map(EditPaintingDto paintingDto, Long id) {
        Painting painting = new Painting(id);
        painting.setTitle(paintingDto.getTitle());
        painting.setYear(paintingDto.getYear());
        painting.setMovement(Movement.valueOf(paintingDto.getMovement().name()));
        painting.setStatus(Status.valueOf(paintingDto.getStatus().name()));
        painting.setPaintingEstimatedPrice(map(paintingDto.getPaintingEstimatedPrice()));
        return painting;
    }

    private static PaintingEstimatedPriceDto map(PaintingEstimatedPrice price) {
        PaintingEstimatedPriceDto priceDto = new PaintingEstimatedPriceDto();
        priceDto.setEstimatedPrice(price.getEstimatedPrice());
        priceDto.setCurrency(CurrencyDto.valueOf(price.getCurrency().name()));
        return priceDto;
    }

    private static PaintingEstimatedPrice map(PaintingEstimatedPriceDto priceDto) {
        PaintingEstimatedPrice price = new PaintingEstimatedPrice();
        price.setEstimatedPrice(priceDto.getEstimatedPrice());
        price.setCurrency(Currency.valueOf(priceDto.getCurrency().name()));
        return price;
    }
}