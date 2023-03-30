package com.artgallery;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import java.util.ArrayList;
import java.util.List;

class ArtMapperTest {

    private Painting getPainting() {
        Author author = new Author();
        author.setFirstName("First");
        author.setSecondName(null);
        author.setLastName("Last");
        author.setCountry("Author country");
        Painting painting = new Painting(1l);
        painting.setTitle("Painting title");
        painting.setYear(1000l);
        painting.setMovement(Movement.valueOf("IMPRESSIONISM"));
        painting.setAuthor(author);
        return painting;
    }

    private List<Painting> paintings() {
        List<Painting> paintings = new ArrayList<>();
        paintings.add(getPainting());
        return paintings;
    }
}