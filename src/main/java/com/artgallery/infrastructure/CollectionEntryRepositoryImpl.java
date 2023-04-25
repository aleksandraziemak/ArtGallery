package com.artgallery.infrastructure;

import com.artgallery.domain.CollectionEntryRepository;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.infrastructure.dao.CollectionEntryDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CollectionEntryRepositoryImpl implements CollectionEntryRepository {

    private final CollectionEntryDao collectionEntryDao;

    @Override
    public List<CollectionEntry> getCollectionEntries() {
        return collectionEntryDao.getCollectionEntries();
    }

    @Override
    public Long addCollectionEntry(Long paintingId, Long authorId, Long curatorId) {
        return collectionEntryDao.addCollectionEntry(paintingId, authorId, curatorId);
    }

    @Override
    public void updateCollectionEntry(CollectionEntry collection) {
        collectionEntryDao.updateCollectionEntry(collection);
    }

    @Override
    public void deleteCollectionEntry(Long id) {
        collectionEntryDao.deleteCollectionEntry(id);
    }
}