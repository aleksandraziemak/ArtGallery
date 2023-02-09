package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Painting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArtService {

    private static final ArtRepository repository = new ArtRepository();

    public void showMyCollection() {
        List<Painting> paintings = repository.getPaintings();
        IntStream.range(0, paintings.size())
                .forEach(index -> System.out.println((index + 1) + ". " + paintings.get(index).getFullDescription()));
    }

    public void showMyArtists() {
        List<Author> authors = repository.getPaintings().stream()
                .map(Painting::getAuthor)
                .distinct()
                .toList();
        IntStream.range(0, authors.size())
                .forEach(index -> System.out.println((index + 1) +". " + authors.get(index).getDescription()));
    }
}