package com.artgallery.api.author;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditAuthorDto {
    private String firstName;
    private String secondName;
    private String lastName;
    private String country;
}
