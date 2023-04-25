package com.artgallery.infrastructure;

import com.artgallery.domain.ClientRepository;
import com.artgallery.domain.model.Client;
import com.artgallery.infrastructure.dao.ClientDao;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientDao clientDao;

    @Override
    public List<Client> getClients() {
        return clientDao.getClients();
    }

    @Override
    public Long addClient(Client client) {
        return clientDao.addClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientDao.deleteClient(id);
    }
}