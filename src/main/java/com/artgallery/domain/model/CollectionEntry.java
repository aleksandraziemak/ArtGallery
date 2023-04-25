package com.artgallery.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CollectionEntry {
    private Long id;
    private Painting painting;
    private Author author;
    private Curator curator;

    public CollectionEntry() {
    }

    public CollectionEntry(Long id) {
        this.id = id;
    }
}
