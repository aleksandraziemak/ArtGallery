package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuthorDto {
    private String firstName;
    private String secondName;
    private String lastName;
    private String country;
}
