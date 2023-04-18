package com.artgallery.api;

import com.artgallery.domain.model.Client;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;
import java.util.List;
import org.jooq.impl.QOM;

public class ClientMapperDto {

    public static List<ClientDto> map(List<Client> client) {
        return client.stream()
            .map(ClientMapperDto::map)
            .toList();
    }

    public static ClientDto map(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        return clientDto;
    }

    public static Client map(AddClientDto clientDto) {
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        return client;
    }

    public static Client map(EditClientDto clientDto, Long id) {
        Client client = new Client(id);
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        return client;
    }
}