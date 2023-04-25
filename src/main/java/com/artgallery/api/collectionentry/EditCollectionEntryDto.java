package com.artgallery.api.collectionentry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditCollectionEntryDto {
    private Long id;
    private Long paintingId;
    private Long authorId;
    private Long curatorId;
}
