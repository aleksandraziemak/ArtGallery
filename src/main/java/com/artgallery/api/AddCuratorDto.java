package com.artgallery.api;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCuratorDto {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
}
