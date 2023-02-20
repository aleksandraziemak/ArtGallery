package com.artgallery.util;

import com.artgallery.model.Painting;

import java.util.List;


public class InputValidatorUtil {

    public static boolean validate(String input, InputValidator validator) {
        return switch (validator) {
            case YES_NO -> yesNoValidate(input);
            case AUTHOR -> authorValidate(input);
            case PAINTING -> paintingValidate(input);
        };
    }

    public static boolean isInputInvalid(String input, List<Painting> paintings) {
        boolean inputInvalid = !input.matches("[1-9]") || Integer.parseInt(input) < 1 || Integer.parseInt(input) > paintings.size();
        if (inputInvalid) {
            System.out.println("Wrong input, please choose number between 1 and " + paintings.size());
        }
        return inputInvalid;
    }

    public static boolean yesNoValidate(String input) {
        boolean inputInvalid = !input.matches("[y]") && !input.matches("[n]");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [y]es / [n]o");
        }
        return inputInvalid;
    }

    public static boolean paintingValidate(String input) {
        boolean inputInvalid = !input.matches("[t]") && !input.matches("[x]") && !input.matches("[m]");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [t]itle / [x]year / [m]ovement");
        }
        return inputInvalid;
    }

    public static boolean authorValidate(String input) {
        boolean inputInvalid = !input.matches("[f]") && !input.matches("[l]") && !input.matches("[c]");
        if (inputInvalid) {
            System.out.println("Wrong input, choose: [f]irst name / [l]ast name / [c]ountry");
        }
        return inputInvalid;
    }
}