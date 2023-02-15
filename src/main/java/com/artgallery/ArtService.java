package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Painting;
import com.artgallery.util.UuidGeneratorUtil;

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
        painting.setMovement(scanner.nextLine());
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
                index = getIndex();
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
        String option = getOption();
        editAuthor(painting, option);
        System.out.println("Do you want to change data: " + "\n" + painting.getDescription() + "? [y]es / [n]o");
        option = getOption();
        editPainting(painting, option);
    }

    private void editAuthor(Painting painting, String option) {
        switch (option) {
            case "y":
                System.out.println("What do you want to edit? [f]irst name / [l]ast name / [c]ountry");
                String authorOption = getOptionAuthor();
                authorOption(painting, authorOption);
            case "n":
                System.out.println("Artist data:" + "\n" + painting.getAuthor().getDescription());
                break;
        }
    }

    private void authorOption(Painting painting, String authorOption) {
        switch (authorOption) {
            case "f":
                System.out.println("Current first name: " + painting.getAuthor().getFirstName() + "\n" + "New input:");
                repository.editFirstName(painting);
                break;
            case "l":
                System.out.println("Current last name: " + painting.getAuthor().getLastName() + "\n" + "New input:");
                repository.editLastName(painting);
                break;
            case "c":
                System.out.println("Current last country: " + painting.getAuthor().getCountry() + "\n" + "New input:");
                repository.editCountry(painting);
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }

    private void editPainting(Painting painting, String option) {
        switch (option) {
            case "y":
                System.out.println("What do you want to edit? [t]itle / [y]ear / [m]ovement");
                String paintingOption = getOptionPainting();
                paintingOption(painting, paintingOption);
            case "n":
                System.out.println("Painting data:" + "\n" + painting.getDescription());
                break;
        }
    }

    private void paintingOption(Painting painting, String paintingOption) {
        switch (paintingOption) {
            case "t":
                System.out.println("Current title: " + painting.getTitle() + "\n" + "New input:");
                repository.editTitle(painting);
                break;
            case "y":
                System.out.println("Current year: " + painting.getYear() + "\n" + "New input:");
                repository.editYear(painting);
                break;
            case "m":
                System.out.println("Current movement: " + painting.getMovement() + "\n" + "New input:");
                repository.editMovement(painting);
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }
    }

    private String getOption() {
        String input;
        do {
            input = scanner.next();
        } while (chooseYesOrNoExceptions(input));
        return input;
    }

    private boolean chooseYesOrNoExceptions(String input) {
        boolean inputInvalid = !input.matches("[y]") && !input.matches("[n]");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [y]es / [n]o");
        }
        return inputInvalid;
    }

    private String getOptionAuthor() {
        String input;
        do {
            input = scanner.nextLine();
        } while (chooseAuthorOptionExceptions(input));
        return input;
    }

    private boolean chooseAuthorOptionExceptions(String input) {
        boolean inputInvalid = !input.matches("[f]") && !input.matches("[l]") && !input.matches("c");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [f]irst name / [l]ast name / [c]ountry");
        }
        return inputInvalid;
    }

    private String getOptionPainting() {
        String input;
        do {
            input = scanner.nextLine();
        } while (choosePaintingOptionExceptions(input));
        return input;
    }

    private boolean choosePaintingOptionExceptions(String input) {
        boolean inputInvalid = !input.matches("[t]") && !input.matches("[y]") && !input.matches("m");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [t]itle / [y]ear / [m]ovement");
        }
        return inputInvalid;
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