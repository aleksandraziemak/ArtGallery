package com.artgallery.api.curator;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuratorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
}
