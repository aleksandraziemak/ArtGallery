package com.artgallery.api.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;

    public ClientDto() {
    }

    public ClientDto(Long id) {
        this.id = id;
    }
}
