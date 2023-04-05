package com.artgallery.api;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Curator;
import java.util.List;

public class CuratorMapperDto {

    public static List<CuratorDto> map(List<Curator> curators) {
        return curators.stream()
            .map(CuratorMapperDto::map)
            .toList();
    }

    public static CuratorDto map(Curator curator) {
        CuratorDto curatorDto = new CuratorDto();
        curatorDto.setId(curator.getId());
        curatorDto.setFirstName(curator.getFirstName());
        curatorDto.setLastName(curator.getLastName());
        return curatorDto;
    }

    public static Curator map(AddCuratorDto curatorDto) {
        Curator curator = new Curator();
        curator.setFirstName(curatorDto.getFirstName());
        curator.setLastName(curatorDto.getLastName());
        curator.setSalary(curatorDto.getSalary());
        return curator;
    }
}
