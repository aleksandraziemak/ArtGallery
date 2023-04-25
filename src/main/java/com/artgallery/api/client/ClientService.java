package com.artgallery.api.client;

import com.artgallery.domain.model.Client;
import java.util.List;

public interface ClientService {

    List<Client> getClients();

    void addClient(Client client);

    void editClient(Client client);

    void deleteClient(Long id);
}
