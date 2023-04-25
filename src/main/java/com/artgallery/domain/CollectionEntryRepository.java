package com.artgallery.domain;

import com.artgallery.domain.model.CollectionEntry;
import java.util.List;

public interface CollectionEntryRepository {

    List<CollectionEntry> getCollectionEntries();

    Long addCollectionEntry(Long paintingId, Long authorId, Long curatorId);

    void updateCollectionEntry(CollectionEntry collectionEntry);

    void deleteCollectionEntry(Long id);
}