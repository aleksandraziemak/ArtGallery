package com.artgallery.infrastructure;

import com.artgallery.domain.ArtRepository;
import com.artgallery.domain.model.Painting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ArtRepositoryJson implements ArtRepository {

    private static final String PATH_TO_JSON_FILE = "src/main/resources/Paintings.json";

    @Override
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

    @Override
    public void addPainting(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.add(painting);
        JSONArray jsonPainting = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonPainting);
    }

    @Override
    public void updatePainting(Painting painting) {
        List<Painting> paintings = getPaintings();
        paintings.remove(painting);
        paintings.add(painting);
        JSONArray jsonArray = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonArray);
    }

    @Override
    public void deletePainting(UUID id) {
        List<Painting> paintings = getPaintings();
        paintings.remove(getPainting(id, paintings));
        JSONArray jsonPaintings = ArtMapper.mapPaintings(paintings);
        writeToFile(jsonPaintings);
    }

    private Painting getPainting(UUID id, List<Painting> paintings) {
        return paintings.stream()
                .filter(painting -> painting.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("ID %s not found", id)));
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