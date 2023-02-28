package com.artgallery.util;

import com.artgallery.domain.model.Painting;
import com.artgallery.domain.util.InputValidatorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class InputValidatorUtilTest {
    
    @Test
    @DisplayName("size validate")
    void isInputInvalid() {
        Assertions.assertTrue(InputValidatorUtil.isInputValid("1", getPaintings()), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isInputValid("2", getPaintings()), "Should return true for valid input");
        Assertions.assertFalse(InputValidatorUtil.isInputValid("inputInvalid", getPaintings()), "Should return false for invalid input");
    }

    @Test
    @DisplayName("yes/no validate")
    void isValidYesNoInput() {
        Assertions.assertTrue(InputValidatorUtil.isValidYesNoInput("y"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidYesNoInput("n"), "Should return true for valid input");
        Assertions.assertFalse(InputValidatorUtil.isValidYesNoInput("invalidInput"), "Should return false for invalid input");
    }

    @Test
    @DisplayName("painting validate")
    void isValidPaintingInput() {
        Assertions.assertTrue(InputValidatorUtil.isValidPaintingInput("t"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidPaintingInput("x"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidPaintingInput("m"), "Should return true for valid input");
        Assertions.assertFalse(InputValidatorUtil.isValidPaintingInput("invalidInput"), "Should return false for invalid input");
    }

    @Test
    @DisplayName("author validate")
    void isValidAuthorInput() {
        Assertions.assertTrue(InputValidatorUtil.isValidAuthorInput("f"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidAuthorInput("s"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidAuthorInput("l"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidAuthorInput("c"), "Should return true for valid input");
        Assertions.assertFalse(InputValidatorUtil.isValidAuthorInput("invalidInput"), "Should return false for invalid input");
    }

    @Test
    @DisplayName("search validate")
    void isValidSearch() {
        Assertions.assertTrue(InputValidatorUtil.isValidSearch("t"), "Should return true for valid input");
        Assertions.assertTrue(InputValidatorUtil.isValidSearch("l"), "Should return true for valid input");
        Assertions.assertFalse(InputValidatorUtil.isValidSearch("invalidInput"), "Should return false for invalid input");
    }

    private List<Painting> getPaintings() {
        List<Painting> paintings = new ArrayList<>();
        paintings.add(new Painting(UUID.fromString("1d0252a9-96e4-4d76-9afa-884165be9ee0")));
        paintings.add(new Painting(UUID.fromString("1d0252a9-96e4-4d76-9afa-884165be9ee9")));
        return paintings;
    }
}