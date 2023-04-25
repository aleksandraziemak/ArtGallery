package com.artgallery.api.collectionentry;

import com.artgallery.domain.model.CollectionEntry;
import java.util.List;

public interface CollectionEntryService {

    List<CollectionEntry> getCollectionEntries();

    void addCollectionEntry(Long paintingId, Long authorId, Long curatorId);

    void editCollectionEntry(CollectionEntry collectionEntry);

    void deleteCollectionEntry(Long id);
}
