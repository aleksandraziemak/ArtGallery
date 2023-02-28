package com.artgallery.domain.util;

import com.artgallery.domain.model.Painting;

import java.util.List;


public class InputValidatorUtil {

    public static boolean isValid(String input, InputValidator validator) {
        return switch (validator) {
            case YES_NO -> isValidYesNoInput(input);
            case AUTHOR -> isValidAuthorInput(input);
            case PAINTING -> isValidPaintingInput(input);
            case SEARCH -> isValidSearch(input);
        };
    }

    public static boolean isInputValid(String input, List<Painting> paintings) {
        boolean inputValid = input.matches("[1-9]") && Integer.parseInt(input) > 0 && Integer.parseInt(input) <= paintings.size();
        if (!inputValid) {
            System.out.println("Wrong input, please choose number between 1 and " + paintings.size());
        }
        return inputValid;
    }

    public static boolean isValidYesNoInput(String input) {
        boolean inputInvalid = input.matches("[yn]");
        if (!inputInvalid) {
            System.out.println("Wrong input, choose: [y]es / [n]o");
        }
        return inputInvalid;
    }

    public static boolean isValidPaintingInput(String input) {
        boolean inputInvalid = input.matches("[txm]");
        if (!inputInvalid) {
            System.out.println("Wrong input, choose: [t]itle / [x]year / [m]ovement");
        }
        return inputInvalid;
    }

    public static boolean isValidAuthorInput(String input) {
        boolean inputInvalid = input.matches("[fslc]");
        if (!inputInvalid) {
            System.out.println("Wrong input, choose: [f]irst name / [s]econd name / [l]ast name / [c]ountry");
        }
        return inputInvalid;
    }

    public static boolean isValidSearch(String input) {
        boolean inputInvalid = input.matches("[lt]");
        if (!inputInvalid) {
            System.out.println("Wrong input, choose: [l]ast name of an author / [t]itle of a painting");
        }
        return inputInvalid;
    }
}