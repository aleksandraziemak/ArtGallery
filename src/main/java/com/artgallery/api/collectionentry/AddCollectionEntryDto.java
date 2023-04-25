package com.artgallery.api.collectionentry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCollectionEntryDto {
    private Long paintingId;
    private Long authorId;
    private Long curatorId;
}
