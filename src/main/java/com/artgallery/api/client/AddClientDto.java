package com.artgallery.api.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddClientDto {
    private Long id;
    private String firstName;
    private String lastName;

    public AddClientDto() {
    }

    public AddClientDto(Long id) {
        this.id = id;
    }
}
