package com.artgallery.api.collectionentry;

import com.artgallery.api.author.AuthorDto;
import com.artgallery.api.curator.CuratorDto;
import com.artgallery.api.painting.PaintingDto;
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
