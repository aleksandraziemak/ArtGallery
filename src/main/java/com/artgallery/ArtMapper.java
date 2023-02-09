package com.artgallery;

import com.artgallery.model.Author;
import com.artgallery.model.Painting;
import org.json.simple.JSONObject;

import java.util.UUID;

public class ArtMapper {

    private static final String TITLE = "title";
    private static final String YEAR = "year";
    private static final String MOVEMENT = "movement";
    private static final String ID = "id";
    private static final String AUTHOR = "author";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String COUNTRY = "country";


/*    private static JSONObject mapPainting(Painting painting) {
        JSONObject newPainting = new JSONObject();
        newPainting.put(TITLE, painting.getTitle());
        newPainting.put(YEAR, painting.getYear());
        newPainting.put(MOVEMENT, painting.getMovement());
        newPainting.put(ID, painting.getId().toString());
        JSONObject newAuthor = new JSONObject();
        newAuthor.put(FIRST_NAME, painting.getAuthor().getFirstName());
        newAuthor.put(LAST_NAME, painting.getAuthor().getLastName());
        newAuthor.put(COUNTRY, painting.getAuthor().getLastName());
        newPainting.put(AUTHOR, newAuthor);
        return newPainting;
    }*/

    public static Painting mapJson(JSONObject painting) {
        JSONObject jsonAuthor = (JSONObject) painting.get(AUTHOR);
        Author author = new Author((String) jsonAuthor.get(FIRST_NAME), (String) jsonAuthor.get(LAST_NAME), (String) jsonAuthor.get(COUNTRY));
        return new Painting((String) painting.get(TITLE), (String) painting.get(MOVEMENT), (long) painting.get(YEAR), author, UUID.fromString((String) painting.get(ID)));
    }
}