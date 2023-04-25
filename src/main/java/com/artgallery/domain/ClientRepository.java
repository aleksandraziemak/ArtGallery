package com.artgallery.domain;

import com.artgallery.domain.model.Client;
import java.util.List;

public interface ClientRepository {

    List<Client> getClients();

    Long addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Long id);
}