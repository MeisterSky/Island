package com.javarush.island.sheff.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.javarush.island.sheff.repository.OrganismTypes;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class JsonParser {

    Gson gson = new Gson();
    JsonObject jsonObject;

    public JsonParser(Path pathFile) {

        try (FileReader reader = new FileReader(pathFile.toFile())) {
            jsonObject = gson.fromJson(reader, JsonObject.class);

        } catch (IOException e) {
            System.out.println("Parsing error " + e);
        }

    }

    public <T> T getObject(OrganismTypes organismTypes) {
        return gson.fromJson(jsonObject.getAsJsonObject(organismTypes.getName().toLowerCase()), organismTypes.getType());
    }
}
