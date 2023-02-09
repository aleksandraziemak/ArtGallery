package com.artgallery;

import com.artgallery.model.Painting;

import java.util.List;
import java.util.stream.IntStream;

public class ArtService {

    private static final ArtRepository repository = new ArtRepository();

    public void showMyCollection() {
        List<Painting> paintings = repository.getPaintingsFromJsonFile();
        IntStream.range(0, paintings.size())
                .forEach(index -> System.out.println((index + 1) + ". " + paintings.get(index).getFullDescription()));
    }
}