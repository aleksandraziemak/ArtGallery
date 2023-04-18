package com.artgallery.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuratorDto {
    private Long id;
    private String firstName;
    private String lastName;

    public CuratorDto() {
    }
}
