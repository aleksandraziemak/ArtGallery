package com.artgallery.domain.model;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Painting {
    private Long id;
    private String title;
    private Long year;
    private Movement movement;
    private Status status;

    public Painting() {
    }

    public Painting(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Painting painting = (Painting) o;
        return Objects.equals(id, painting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}