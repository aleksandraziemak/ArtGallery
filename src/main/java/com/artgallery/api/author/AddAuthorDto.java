package com.artgallery.api.author;

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
