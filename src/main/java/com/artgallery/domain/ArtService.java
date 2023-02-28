package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.util.ArtServiceUtil;
import com.artgallery.domain.util.InputType;
import com.artgallery.domain.util.InputValidator;
import com.artgallery.domain.util.UuidGeneratorUtil;
import com.artgallery.infrastructure.ArtRepositoryJson;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArtService {

    private final ArtRepository repository = new ArtRepositoryJson();
    private final Scanner scanner = new Scanner(System.in);

    public List<Painting> getPaintings() {
        return repository.getPaintings();
    }

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

    private void showPaintings(List<Painting> searchedPaintings) {
        if (searchedPaintings.isEmpty()) {
            System.out.println("No paintings found");
        } else {
            IntStream.range(0, searchedPaintings.size())
                    .forEach(index -> System.out.println((index + 1) + ". " + searchedPaintings.get(index).getShortDesctription()));
        }
    }

    public void searchPainting() {
        List<Painting> paintings = repository.getPaintings();
        System.out.println("Searching Painting...");
        System.out.println("Search by: [l]ast name / [t]itle of painting");
        InputType input = ArtServiceUtil.getOption(scanner, InputValidator.SEARCH);
        System.out.println("Search for:");
        String search = scanner.next().toLowerCase();
        List<Painting> searchedPaintings = searchPainting(paintings, input, search);
        showPaintings(searchedPaintings);
    }

    private List<Painting> searchPainting(List<Painting> paintings, InputType input, String search) {
        List <Painting> searchedPaintings;
        switch (input) {
            case LAST_NAME:
                searchedPaintings = searchByAuthor(paintings, search);
                return searchedPaintings;
            case TITLE:
                searchedPaintings = searchByPainting(paintings, search);
                return searchedPaintings;
        }
        return null;
    }

    private List<Painting> searchByAuthor(List<Painting> paintings, String search) {
        return paintings.stream()
                .filter(painting -> painting.getAuthor().getLastName().toLowerCase().contains(search))
                .collect(Collectors.toList());
    }

    private List<Painting> searchByPainting(List<Painting> paintings, String search) {
        return paintings.stream()
                .filter(painting -> painting.getTitle().toLowerCase().contains(search))
                .collect(Collectors.toList());
    }

    public void buyPainting() {
        Painting painting = new Painting(UuidGeneratorUtil.uuidGenerate());
        Author author = new Author();
        System.out.println("Buying new painting...");
        System.out.println("Set author data");
        System.out.println("Firstname: ");
        author.setFirstName(scanner.nextLine());
        System.out.println("(optional) Second name: ");
        author.setSecondName(scanner.nextLine());
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
        while (true) {
            try {
                Painting painting = ArtServiceUtil.getPainting(scanner, paintings);
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
        InputType option = ArtServiceUtil.getOption(scanner, InputValidator.YES_NO);
        Author editedAuthor = editAuthor(painting.getAuthor(), option);
        painting.setAuthor(editedAuthor);

        System.out.println("Do you want to change data: " + "\n" + painting.getDescription() + "? [y]es / [n]o");
        option = ArtServiceUtil.getOption(scanner, InputValidator.YES_NO);
        Painting editedPainting = editPainting(painting, option);

        repository.updatePainting(editedPainting);
    }

    private Author editAuthor(Author author, InputType option) {
        switch (option) {
            case YES:
                System.out.println("What do you want to edit? [f]irst name / [s]econd name / [l]ast name / [c]ountry");
                InputType authorOption = ArtServiceUtil.getOption(scanner, InputValidator.AUTHOR);
                return edit(author, authorOption);
            case NO:
                System.out.println("Artist data:" + "\n" + author.getDescription());
                return author;
        }
        return author;
    }

    private Author edit(Author author, InputType authorOption) {
        switch (authorOption) {
            case FIRST_NAME:
                System.out.println("Current first name: " + author.getFirstName() + "\n" + "New input:");
                author.setFirstName(scanner.next());
                break;
            case SECOND_NAME:
                System.out.println("Current second name: " + author.getSecondName().orElse("-") + "\n" + "New input:");
                String secondName = scanner.next();
                author.setSecondName(calculateEmptyValue(secondName));
                break;
            case LAST_NAME:
                System.out.println("Current last name: " + author.getLastName() + "\n" + "New input:");
                author.setLastName(scanner.nextLine());
                break;
            case COUNTRY:
                System.out.println("Current last country: " + author.getCountry() + "\n" + "New input:");
                author.setCountry(scanner.nextLine());
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
        return author;
    }

    private String calculateEmptyValue(String text) {
        if (Objects.equals(text, "-")) {
            return null;
        } else {
            return text;
        }
    }

    private Painting editPainting(Painting painting, InputType option) {
        switch (option) {
            case YES:
                System.out.println("What do you want to edit? [t]itle / [x]year / [m]ovement");
                InputType paintingOption = ArtServiceUtil.getOption(scanner, InputValidator.PAINTING);
                return edit(painting, paintingOption);
            case NO:
                System.out.println("Painting data:" + "\n" + painting.getDescription());
                return painting;
        }
        return painting;
    }

    private Painting edit(Painting painting, InputType paintingOption) {
        switch (paintingOption) {
            case TITLE:
                System.out.println("Current title: " + painting.getTitle() + "\n" + "New input:");
                painting.setTitle(scanner.nextLine());
                break;
            case YEAR:
                System.out.println("Current year: " + painting.getYear() + "\n" + "New input:");
                painting.setYear(scanner.nextLong());
                break;
            case MOVEMENT:
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
        while (true) {
            try {
                Painting painting = ArtServiceUtil.getPainting(scanner, paintings);
                repository.sellPainting(painting);
                break;
            } catch (InputMismatchException | IndexOutOfBoundsException exception) {
                System.out.println("Please choose number between 1 and " + repository.getPaintings().size());
                scanner.nextLine();
            }
        }
    }

}