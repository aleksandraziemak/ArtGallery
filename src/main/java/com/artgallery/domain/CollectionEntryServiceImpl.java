package com.artgallery.domain;

import com.artgallery.api.collectionentry.CollectionEntryService;
import com.artgallery.domain.model.CollectionEntry;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class CollectionEntryServiceImpl implements CollectionEntryService {

    private final CollectionEntryRepository collectionEntryRepository;

    @Override
    public List<CollectionEntry> getCollectionEntries() {
        return collectionEntryRepository.getCollectionEntries();
    }

    @Override
    public void addCollectionEntry(Long paintingId, Long authorId, Long curatorId) {
        collectionEntryRepository.addCollectionEntry(paintingId, authorId, curatorId);
    }

    @Override
    public void editCollectionEntry(CollectionEntry collectionEntry) {
        collectionEntryRepository.updateCollectionEntry(collectionEntry);
    }

    @Override
    public void deleteCollectionEntry(Long id) {
        collectionEntryRepository.deleteCollectionEntry(id);
    }
}