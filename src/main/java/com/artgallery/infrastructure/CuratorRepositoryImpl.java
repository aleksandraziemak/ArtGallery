package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.CURATOR;

import com.artgallery.domain.CuratorRepository;
import com.artgallery.domain.model.Curator;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class CuratorRepositoryImpl implements CuratorRepository {

    private final DSLContext dslContext;

    public CuratorRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Curator> getCurators() {
        return dslContext.selectFrom(CURATOR)
            .fetch()
            .map(ArtMapper::mapCurator);
    }

    @Override
    public Long addCurator(Curator curator) {
        return dslContext.insertInto(CURATOR,
                CURATOR.FIRST_NAME, CURATOR.LAST_NAME, CURATOR.SALARY)
            .values(curator.getFirstName(), curator.getLastName(), curator.getSalary())
            .returning()
            .fetchOne()
            .getId();
    }

    @Override
    public void updateCurator(Curator curator) {
        dslContext.update(CURATOR)
            .set(CURATOR.FIRST_NAME, curator.getFirstName())
            .set(CURATOR.LAST_NAME, curator.getLastName())
            .set(CURATOR.SALARY, curator.getSalary())
            .where(CURATOR.ID.eq(curator.getId()))
            .execute();
    }

    @Override
    public void deleteCurator(Long id) {
        dslContext.deleteFrom(CURATOR)
            .where(CURATOR.ID.eq(id))
            .execute();
    }
}