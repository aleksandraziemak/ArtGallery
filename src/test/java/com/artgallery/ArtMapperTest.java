package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Movement;
import com.artgallery.model.Painting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ArtMapperTest {

    @Test
    @DisplayName("map paintings to JSONArray")
    void mapPaintings() {
        JSONArray result = ArtMapper.mapPaintings(paintings());
        Assertions.assertEquals(result.size(), jsonArrayExpected().size());
        Assertions.assertEquals(result.get(0), jsonArrayExpected().get(0));
    }

    @Test
    @DisplayName("map JSONObject from painting")
    void mapPainting() {
        JSONObject result = ArtMapper.mapPainting(getPainting());
        Assertions.assertEquals(result.get(TestUtil.ID), jsonObjectExpected().get(TestUtil.ID));
        Assertions.assertEquals(result.get(TestUtil.FIRST_NAME), jsonObjectExpected().get(TestUtil.FIRST_NAME));
        Assertions.assertEquals(result.get(TestUtil.SECOND_NAME), jsonObjectExpected().get(TestUtil.SECOND_NAME));
        Assertions.assertEquals(result.get(TestUtil.LAST_NAME), jsonObjectExpected().get(TestUtil.LAST_NAME));
        Assertions.assertEquals(result.get(TestUtil.COUNTRY), jsonObjectExpected().get(TestUtil.COUNTRY));
        Assertions.assertEquals(result.get(TestUtil.TITLE), jsonObjectExpected().get(TestUtil.TITLE));
        Assertions.assertEquals(result.get(TestUtil.YEAR), jsonObjectExpected().get(TestUtil.YEAR));
        Assertions.assertEquals(result.get(TestUtil.MOVEMENT), jsonObjectExpected().get(TestUtil.MOVEMENT));
    }

    @Test
    @DisplayName("map painting from JSONObject")
    void mapJson() {
        Painting result = ArtMapper.mapJson(jsonObjectExpected());
        Assertions.assertEquals(result.getId(), getPainting().getId());
        Assertions.assertEquals(result.getAuthor().getFirstName(), getPainting().getAuthor().getFirstName());
        Assertions.assertEquals(result.getAuthor().getSecondName(), getPainting().getAuthor().getSecondName());
        Assertions.assertEquals(result.getAuthor().getLastName(), getPainting().getAuthor().getLastName());
        Assertions.assertEquals(result.getAuthor().getCountry(), getPainting().getAuthor().getCountry());
        Assertions.assertEquals(result.getTitle(), getPainting().getTitle());
        Assertions.assertEquals(result.getYear(), getPainting().getYear());
        Assertions.assertEquals(result.getMovement(), getPainting().getMovement());
    }

    private Painting getPainting() {
        Painting painting = new Painting(UUID.fromString("236ce69a-11f3-4378-afa5-690ed44e3826"));
        Author author = new Author();
        author.setFirstName("First");
        author.setSecondName(null);
        author.setLastName("Last");
        author.setCountry("Author country");
        painting.setTitle("Painting title");
        painting.setYear(1000);
        painting.setMovement(Movement.valueOf("IMPRESSIONISM"));
        painting.setAuthor(author);
        return painting;
    }

    private List<Painting> paintings() {
        List<Painting> paintings = new ArrayList<>();
        paintings.add(getPainting());
        return paintings;
    }

    private JSONObject jsonObjectExpected() {
        JSONObject jsonPainting = new JSONObject();
        JSONObject jsonAuthor = new JSONObject();
        jsonPainting.put(TestUtil.ID, "236ce69a-11f3-4378-afa5-690ed44e3826");
        jsonAuthor.put(TestUtil.FIRST_NAME, "First");
        jsonAuthor.put(TestUtil.SECOND_NAME, null);
        jsonAuthor.put(TestUtil.LAST_NAME, "Last");
        jsonAuthor.put(TestUtil.COUNTRY, "Author country");
        jsonPainting.put(TestUtil.AUTHOR, jsonAuthor);
        jsonPainting.put(TestUtil.TITLE, "Painting title");
        jsonPainting.put(TestUtil.YEAR, 1000L);
        jsonPainting.put(TestUtil.MOVEMENT, "IMPRESSIONISM");
        return jsonPainting;
    }

    private JSONArray jsonArrayExpected() {
        JSONArray jsonArrayExpected = new JSONArray();
        jsonArrayExpected.add(jsonObjectExpected());
        return jsonArrayExpected;
    }
}