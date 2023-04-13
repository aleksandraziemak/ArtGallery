package com.artgallery.api;

import com.artgallery.domain.model.CollectionEntry;
import java.util.List;

public class CollectionEntryMapperDto {

    public static List<CollectionEntryDto> map(List<CollectionEntry> collectionEntry) {
        return collectionEntry.stream()
            .map(CollectionEntryMapperDto::map)
            .toList();
    }

    public static CollectionEntryDto map(CollectionEntry collectionEntry) {
        CollectionEntryDto collectionEntryDto = new CollectionEntryDto();
        collectionEntryDto.setId(collectionEntry.getId());
        collectionEntryDto.setPaintingDto(PaintingMapperDto.map(collectionEntry.getPainting()));
        collectionEntryDto.setAuthorDto(AuthorMapperDto.map(collectionEntry.getAuthor()));
        collectionEntryDto.setCuratorDto(CuratorMapperDto.map(collectionEntry.getCurator()));
        return collectionEntryDto;
    }

    public static CollectionEntry map(AddCollectionEntryDto collectionEntryDto) {
        CollectionEntry collection = new CollectionEntry();
        collection.setPainting(PaintingMapperDto.map(collectionEntryDto.getPaintingId()));
        collection.setAuthor(AuthorMapperDto.map(collectionEntryDto.getAuthorId()));
        collection.setCurator(CuratorMapperDto.map(collectionEntryDto.getCuratorId()));
        return collection;
    }

    public static CollectionEntry map(EditCollectionEntryDto collectionEntryDto, Long id) {
        CollectionEntry collection = new CollectionEntry(id);
        collection.setPainting(PaintingMapperDto.map(collectionEntryDto.getPaintingId()));
        collection.setAuthor(AuthorMapperDto.map(collectionEntryDto.getAuthorId()));
        collection.setCurator(CuratorMapperDto.map(collectionEntryDto.getCuratorId()));
        return collection;
    }
}
