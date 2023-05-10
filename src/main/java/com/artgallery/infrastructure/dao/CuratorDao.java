package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.CURATOR;

import com.artgallery.domain.model.Curator;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CuratorDao {

    private final DSLContext dslContext;

    public List<Curator> getCurators() {
        return dslContext.selectFrom(CURATOR)
            .fetch()
            .map(ArtMapper::mapCurator);
    }

    public Long addCurator(Curator curator) {
        return dslContext.insertInto(CURATOR)
            .set(CURATOR.FIRST_NAME, curator.getFirstName())
            .set(CURATOR.LAST_NAME, curator.getLastName())
            .set(CURATOR.SALARY, curator.getSalary())
            .returning()
            .fetchOne()
            .getId();
    }

    public void updateCurator(Curator curator) {
        dslContext.update(CURATOR)
            .set(CURATOR.FIRST_NAME, curator.getFirstName())
            .set(CURATOR.LAST_NAME, curator.getLastName())
            .set(CURATOR.SALARY, curator.getSalary())
            .where(CURATOR.ID.eq(curator.getId()))
            .execute();
    }

    public void deleteCurator(Long id) {
        dslContext.deleteFrom(CURATOR)
            .where(CURATOR.ID.eq(id))
            .execute();
    }
}