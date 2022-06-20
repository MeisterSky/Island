package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.util.GsonParser;

public class EntityFactory {

    public static void main(String[] args) {

        GsonParser parser = new GsonParser();
        Entity entity = parser.parse();
        System.out.println("Animals " + entity.toString());
    }
}
