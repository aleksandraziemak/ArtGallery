package com.artgallery.util;

import com.artgallery.model.Painting;
import java.util.List;
import java.util.Scanner;

public class ArtServiceUtil {

    public static String getOption(Scanner scanner) {
        String input;
        do {
            input = scanner.next();
        } while (chooseYesOrNoExceptions(input));
        return input;
    }

    private static boolean chooseYesOrNoExceptions(String input) {
        boolean inputInvalid = !input.matches("[y]") && !input.matches("[n]");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [y]es / [n]o");
        }
        return inputInvalid;
    }

    public static String getOptionAuthor(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();
        } while (chooseAuthorOptionExceptions(input));
        return input;
    }

    private static boolean chooseAuthorOptionExceptions(String input) {
        boolean inputInvalid = !input.matches("[f]") && !input.matches("[l]") && !input.matches("c");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [f]irst name / [l]ast name / [c]ountry");
        }
        return inputInvalid;
    }

    public static String getOptionPainting(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();
        } while (choosePaintingOptionExceptions(input));
        return input;
    }

    private static boolean choosePaintingOptionExceptions(String input) {
        boolean inputInvalid = !input.matches("[t]") && !input.matches("[y]") && !input.matches("m");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [t]itle / [y]ear / [m]ovement");
        }
        return inputInvalid;
    }

    public static int getIndex(Scanner scanner, List<Painting> paintings) {
        String input;
        do {
            input = scanner.next();
        } while (isInputInvalid(input, paintings));
        return Integer.parseInt(input) - 1;
    }

    private static boolean isInputInvalid(String input, List<Painting> paintings) {
        boolean inputInvalid = !input.matches("[1-9]") || Integer.parseInt(input) < 1 || Integer.parseInt(input) > paintings.size();
        if (inputInvalid) {
            System.out.println("Wrong input, please choose number between 1 and " + paintings.size());
        }
        return inputInvalid;
    }
}
