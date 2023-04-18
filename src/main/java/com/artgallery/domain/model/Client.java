package com.artgallery.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private Long id;
    private String firstName;
    private String lastName;

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }
}
