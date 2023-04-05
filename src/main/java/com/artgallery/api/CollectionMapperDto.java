package com.artgallery.api;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.CollectionEntry;
import java.util.List;

public class CollectionMapperDto {

    public static List<CollectionEntryDto> map(List<CollectionEntry> collectionEntry) {
        return collectionEntry.stream()
            .map(CollectionMapperDto::map)
            .toList();
    }

    public static CollectionEntryDto map(CollectionEntry collectionEntry) {
        CollectionEntryDto collectionEntryDto = new CollectionEntryDto();
        collectionEntryDto.setPaintingDto(PaintingMapperDto.map(collectionEntry.getPainting()));
        collectionEntryDto.setAuthorDto(AuthorMapperDto.map(collectionEntry.getAuthor()));
        collectionEntryDto.setCuratorDto(CuratorMapperDto.map(collectionEntry.getCurator()));
        return collectionEntryDto;
    }
}
