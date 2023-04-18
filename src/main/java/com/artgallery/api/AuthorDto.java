package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String country;
}
