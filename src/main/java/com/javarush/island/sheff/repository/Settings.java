package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.exception.InitGameException;

import java.util.Properties;
import java.util.stream.Stream;

public enum Settings {
    ROWS,
    COLS,
    DURATION,
    LEFT,
    START,
    NUMBER_OF_BEARS,
    NUMBER_OF_BOAS,
    NUMBER_OF_BOARS,
    NUMBER_OF_BUFFALOES,
    NUMBER_OF_CATERPILLARS,
    NUMBER_OF_DEER,
    NUMBER_OF_DUCKS,
    NUMBER_OF_EAGLES,
    NUMBER_OF_FOXES,
    NUMBER_OF_GOATS,
    NUMBER_OF_HORSES,
    NUMBER_OF_MOUSES,
    NUMBER_OF_PLANTS,
    NUMBER_OF_RABBITS,
    NUMBER_OF_SHEEP,
    NUMBER_OF_WOLFS;

    private static final String PATH = "/config.properties";

    private static Properties properties;

    private Integer value;

    private void init() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(Settings.class.getResourceAsStream(PATH));
            } catch (Exception e) {
                throw new InitGameException("Unable to load " + PATH + " file from classpath.", e);
            }
        }

        value = Integer.parseInt((String) properties
                .get(Stream.of(this.toString().split("_"))
                        .reduce((first, last) -> last)
                        .get()
                        .toLowerCase()));
    }

    public Integer getValue() {
        if (value == null) {
            init();
        }
        return value;
    }
}
