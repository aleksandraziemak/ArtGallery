package com.artgallery;

import com.artgallery.model.Painting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArtRepository {

    private static final String PATH_TO_JSON_FILE = "src/main/resources/Paintings.json";
    Scanner scanner = new Scanner(System.in);

    public List<Painting> getPaintings() {
        ArrayList<Painting> paintings = new ArrayList<>();
        final JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(PATH_TO_JSON_FILE);
            JSONArray jsonPaintings = (JSONArray) parser.parse(fileReader);
            jsonPaintings.forEach(object -> paintings.add(ArtMapper.mapJson((JSONObject) object)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return paintings.stream()
                .sorted(Comparator.comparing(Painting::getYear))
                .collect(Collectors.toList());
    }

    public void addPainting(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.add(painting);
        JSONArray jsonPainting = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonPainting);
    }

    public void editFirstName(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        painting.getAuthor().setFirstName(scanner.nextLine());
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    public void editLastName(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        painting.getAuthor().setLastName(scanner.nextLine());
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    public void editCountry(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        painting.getAuthor().setCountry(scanner.nextLine());
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    public void editTitle(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        painting.setTitle(scanner.nextLine());
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    public void editYear(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        painting.setYear(scanner.nextLong());
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    public void editMovement(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        painting.setMovement(scanner.nextLine());
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    public void sellPainting(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        JSONArray jsonPaintings = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonPaintings);
    }

    private void writeToFile(JSONArray jsonPaintings) {
        try (FileWriter file = new FileWriter(PATH_TO_JSON_FILE)) {
            file.write(jsonPaintings.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}