package com.artgallery.api;

public class CollectionEntryDto {
    private Long id;
    private PaintingDto paintingDto;
    private AuthorDto authorDto;
    private CuratorDto curatorDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaintingDto getPaintingDto() {
        return paintingDto;
    }

    public void setPaintingDto(PaintingDto paintingDto) {
        this.paintingDto = paintingDto;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public CuratorDto getCuratorDto() {
        return curatorDto;
    }

    public void setCuratorDto(CuratorDto curatorDto) {
        this.curatorDto = curatorDto;
    }
}
