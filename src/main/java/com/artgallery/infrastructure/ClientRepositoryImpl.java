package com.artgallery.infrastructure;

import static com.artgallery.dao.db.Tables.CLIENT;

import com.artgallery.domain.ClientRepository;
import com.artgallery.domain.model.Client;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final DSLContext dslContext;

    public ClientRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Client> getClients() {
        return dslContext.selectFrom(CLIENT)
            .fetch()
            .map(ArtMapper::mapClient);
    }

    @Override
    public Long addClient(Client client) {
        return dslContext.insertInto(CLIENT,
                CLIENT.FIRST_NAME, CLIENT.LAST_NAME)
            .values(client.getFirstName(), client.getLastName())
            .returning()
            .fetchOne()
            .getId();
    }

    @Override
    public void updateClient(Client client) {
        dslContext.update(CLIENT)
            .set(CLIENT.FIRST_NAME, client.getFirstName())
            .set(CLIENT.LAST_NAME, client.getLastName())
            .where(CLIENT.ID.eq(client.getId()))
            .execute();
    }

    @Override
    public void deleteClient(Long id) {
        dslContext.deleteFrom(CLIENT)
            .where(CLIENT.ID.eq(id))
            .execute();
    }
}