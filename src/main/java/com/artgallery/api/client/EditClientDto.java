package com.artgallery.api.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EditClientDto {
    private Long id;
    private String firstName;
    private String lastName;

    public EditClientDto() {
    }

    public EditClientDto(Long id) {
        this.id = id;
    }
}
