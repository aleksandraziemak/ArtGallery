package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Painting;
import com.artgallery.util.UuidGeneratorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArtService {

    private static final ArtRepository repository = new ArtRepository();
    Scanner scanner = new Scanner(System.in);

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

    public void buyPainting() {
        Painting painting = new Painting(UuidGeneratorUtil.uuidGenerate());
        Author author = new Author();
        System.out.println("Buying new painting...");
        System.out.println("Set author data");
        System.out.println("Firstname: ");
        author.setFirstName(scanner.nextLine());
        System.out.println("Lastname: ");
        author.setLastName(scanner.nextLine());
        System.out.println("Country: ");
        author.setCountry(scanner.nextLine());
        System.out.println("Set painting data");
        System.out.println("Title: ");
        painting.setTitle(scanner.nextLine());
        System.out.println("Movement: ");
        painting.setMovement(scanner.nextLine());
        System.out.println("Year: ");
        painting.setYear(scanner.nextLong());
        painting.setAuthor(author);
        repository.addPainting(painting);
    }
}