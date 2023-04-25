package com.artgallery.domain;

import com.artgallery.api.client.ClientService;
import com.artgallery.domain.model.Client;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    @Override
    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    @Override
    public void editClient(Client client) {
        clientRepository.updateClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteClient(id);
    }
}