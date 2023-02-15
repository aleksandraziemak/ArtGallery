package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Painting;
import com.artgallery.util.UuidGeneratorUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

    private void showMyCollectionShort(List<Painting> paintings) {
        IntStream.range(0, paintings.size())
                .forEach(index -> System.out.println((index + 1) + ". " + paintings.get(index).getShortDesctription()));
    }

    public void showMyArtists() {
        List<Author> authors = repository.getPaintings().stream()
                .map(Painting::getAuthor)
                .distinct()
                .toList();
        IntStream.range(0, authors.size())
                .forEach(index -> System.out.println((index + 1) + ". " + authors.get(index).getDescription()));
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

    public void sellPainting() {
        System.out.println("Selling painting...");
        List<Painting> paintings = repository.getPaintings();
        showMyCollectionShort(paintings);
        System.out.println("Choose painting to sell: ");
        int index;
        while (true) {
            try {
                index = getIndex();
                Painting painting = paintings.get(index);
                repository.sellPainting(painting);
                break;
            } catch (InputMismatchException | IndexOutOfBoundsException exception) {
                System.out.println("Please choose number between 1 and " + repository.getPaintings().size());
                scanner.nextLine();
            }
        }
    }

    private int getIndex() {
        String input;
        do {
            input = scanner.next();
        } while (isInputInvalid(input));
        return Integer.parseInt(input) - 1;
    }

    private boolean isInputInvalid(String input) {
        boolean inputInvalid = !input.matches("[1-9]") || Integer.parseInt(input) < 1 || Integer.parseInt(input) > repository.getPaintings().size();
        if (inputInvalid) {
            System.out.println("Wrong input, please choose number between 1 and " + repository.getPaintings().size());
        }
        return inputInvalid;
    }
}