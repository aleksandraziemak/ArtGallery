package com.artgallery.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Curator {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public Curator() {
    }

    public Curator(Long id) {
        this.id = id;
    }
}
