package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.util.ArtServiceUtil;
import com.artgallery.domain.util.InputType;
import com.artgallery.domain.util.InputValidator;
import com.artgallery.infrastructure.ArtRepositoryJson;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArtService {

    private final ArtRepository repository = new ArtRepositoryJson();
    private final Scanner scanner = new Scanner(System.in);

    public List<Painting> getPaintings() {
        return repository.getPaintings();
    }

    public List<Author> getAuthors() {
        return repository.getPaintings().stream()
                .map(Painting::getAuthor)
                .distinct()
                .toList();
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
        switch (input) {
            case LAST_NAME:
                return searchByAuthor(paintings, search);
            case TITLE:
                return searchByPainting(paintings, search);
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

    public void addPainting(Painting painting) {
        repository.addPainting(painting);
    }

    public void editPainting(Painting painting) {
        repository.updatePainting(painting);
    }

    private void edit(Painting painting) {

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

    public void deletePainting(UUID id) {
        repository.deletePainting(id);
    }

}