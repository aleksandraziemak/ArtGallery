package com.artgallery.infrastructure.dao;

import static com.artgallery.dao.db.Tables.CLIENT;

import com.artgallery.domain.model.Client;
import com.artgallery.infrastructure.ArtMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientDao {

    private final DSLContext dslContext;

    public List<Client> getClients() {
        return dslContext.selectFrom(CLIENT)
            .fetch()
            .map(ArtMapper::mapClient);
    }

    public Long addClient(Client client) {
        return dslContext.insertInto(CLIENT)
            .set(CLIENT.FIRST_NAME, client.getFirstName())
            .set(CLIENT.LAST_NAME, client.getLastName())
            .returning()
            .fetchOne()
            .getId();
    }

    public void updateClient(Client client) {
        dslContext.update(CLIENT)
            .set(CLIENT.FIRST_NAME, client.getFirstName())
            .set(CLIENT.LAST_NAME, client.getLastName())
            .where(CLIENT.ID.eq(client.getId()))
            .execute();
    }

    public void deleteClient(Long id) {
        dslContext.deleteFrom(CLIENT)
            .where(CLIENT.ID.eq(id))
            .execute();
    }
}