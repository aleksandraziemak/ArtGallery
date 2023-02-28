package com.artgallery.domain.util;

import com.artgallery.domain.model.Painting;

import java.util.List;
import java.util.Scanner;

public class ArtServiceUtil {


    public static InputType getOption(Scanner scanner, InputValidator validator) {
        String input;
        do {
            input = scanner.next();
        } while (!InputValidatorUtil.isValid(input, validator));
        return mapInputType(input);
    }

    private static InputType mapInputType(String input) {
        switch (input) {
            case "y":
                return InputType.YES;
            case "n":
                return InputType.NO;
            case "t":
                return InputType.TITLE;
            case "m":
                return InputType.MOVEMENT;
            case "x":
                return InputType.YEAR;
            case "a":
                return InputType.AUTHOR;
            case "f":
                return InputType.FIRST_NAME;
            case "s":
                return InputType.SECOND_NAME;
            case "l":
                return InputType.LAST_NAME;
            case "c":
                return InputType.COUNTRY;
        }
        throw new IllegalStateException();
    }

    public static Painting getPainting(Scanner scanner, List<Painting> paintings) {
        String input;
        do {
            input = scanner.nextLine();
        } while (!InputValidatorUtil.isInputValid(input, paintings));
        return paintings.get(Integer.parseInt(input) - 1);
    }
}