package com.javarush.island.sheff.util;

import com.google.gson.Gson;
import com.javarush.island.sheff.repository.Entity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {

    public Entity parse() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("src/main/resources/animals.json")) {

            return gson.fromJson(reader, Entity.class);

        } catch (IOException e) {
            System.out.println("Parsing error " + e);
        }

        return null;
    }
}
