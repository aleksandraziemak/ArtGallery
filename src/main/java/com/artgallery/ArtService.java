package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Movement;
import com.artgallery.model.Painting;
import com.artgallery.util.ArtServiceUtil;
import com.artgallery.util.UuidGeneratorUtil;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArtService {

    private final ArtRepository repository = new ArtRepositoryJson();
    private final Scanner scanner = new Scanner(System.in);

    public void showMyCollection() {
        List<Painting> paintings = repository.getPaintings();
        IntStream.range(0, paintings.size())
            .forEach(index -> System.out.println((index + 1) + ". " + paintings.get(index).getFullDescription()));
    }

    public void showMyCollection(List<Painting> paintings) {
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
        painting.setMovement(Movement.valueOf(scanner.nextLine().toUpperCase()));
        System.out.println("Year: ");
        painting.setYear(scanner.nextLong());
        painting.setAuthor(author);
        repository.addPainting(painting);
    }

    public void editPainting() {
        System.out.println("Editing painting...");
        List<Painting> paintings = repository.getPaintings();
        showMyCollection(paintings);
        System.out.println("Choose Painting to edit: ");
        int index;
        while (true) {
            try {
                index = ArtServiceUtil.getIndex(scanner, paintings);
                Painting painting = paintings.get(index);
                edit(painting);
                break;
            } catch (InputMismatchException | IndexOutOfBoundsException exception) {
                System.out.println("Please choose number between 1 and " + repository.getPaintings().size());
                scanner.nextLine();
            }
        }
    }

    private void edit(Painting painting) {
        System.out.println("Do you want to change data: " + "\n" + painting.getAuthor().getDescription() + "? [y]es / [n]o");
        String option = ArtServiceUtil.getOption(scanner);
        Author editedAuthor = editAuthor(painting.getAuthor(), option);
        painting.setAuthor(editedAuthor);

        System.out.println("Do you want to change data: " + "\n" + painting.getDescription() + "? [y]es / [n]o");
        option = ArtServiceUtil.getOption(scanner);
        Painting editedPainting = editPainting(painting, option);

        repository.updatePainting(editedPainting);
    }

    private Author editAuthor(Author author, String option) {
        switch (option) {
            case "y":
                System.out.println("What do you want to edit? [f]irst name / [l]ast name / [c]ountry");
                String authorOption = ArtServiceUtil.getOptionAuthor(scanner);
                return edit(author, authorOption);
            case "n":
                System.out.println("Artist data:" + "\n" + author.getDescription());
                return author;
        }
        return author;
    }

    private Author edit(Author author, String authorOption) {
        switch (authorOption) {
            case "f":
                System.out.println("Current first name: " + author.getFirstName() + "\n" + "New input:");
                author.setFirstName(scanner.nextLine());
                break;
            case "l":
                System.out.println("Current last name: " + author.getLastName() + "\n" + "New input:");
                author.setLastName(scanner.nextLine());
                break;
            case "c":
                System.out.println("Current last country: " + author.getCountry() + "\n" + "New input:");
                author.setCountry(scanner.nextLine());
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
        return author;
    }

    private Painting editPainting(Painting painting, String option) {
        switch (option) {
            case "y":
                System.out.println("What do you want to edit? [t]itle / [y]ear / [m]ovement");
                String paintingOption = ArtServiceUtil.getOptionPainting(scanner);
                return edit(painting, paintingOption);
            case "n":
                System.out.println("Painting data:" + "\n" + painting.getDescription());
                return painting;
        }
        return painting;
    }

    private Painting edit(Painting painting, String paintingOption) {
        switch (paintingOption) {
            case "t":
                System.out.println("Current title: " + painting.getTitle() + "\n" + "New input:");
                painting.setTitle(scanner.nextLine());
                break;
            case "y":
                System.out.println("Current year: " + painting.getYear() + "\n" + "New input:");
                painting.setYear(scanner.nextLong());
                break;
            case "m":
                System.out.println("Current movement: " + painting.getMovement() + "\n" + "New input:");
                painting.setMovement(Movement.valueOf(scanner.nextLine().toUpperCase()));
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
        return painting;
    }

    public void sellPainting() {
        System.out.println("Selling painting...");
        List<Painting> paintings = repository.getPaintings();
        showMyCollectionShort(paintings);
        System.out.println("Choose painting to sell: ");
        int index;
        while (true) {
            try {
                index = ArtServiceUtil.getIndex(scanner, paintings);
                Painting painting = paintings.get(index);
                repository.sellPainting(painting);
                break;
            } catch (InputMismatchException | IndexOutOfBoundsException exception) {
                System.out.println("Please choose number between 1 and " + repository.getPaintings().size());
                scanner.nextLine();
            }
        }
    }

}