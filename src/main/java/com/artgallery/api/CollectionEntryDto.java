package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectionEntryDto {
    private Long id;
    private PaintingDto paintingDto;
    private AuthorDto authorDto;
    private CuratorDto curatorDto;
}
