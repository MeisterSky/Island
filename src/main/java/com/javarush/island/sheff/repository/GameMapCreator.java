package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.util.Randomizer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record GameMapCreator(OrganismFactory organismFactory) {

    public GameMap createRandomStartedGameMap() {
        int rows = Settings.ROWS.getValue();
        int cols = Settings.COLS.getValue();
        GameMap gameMap = new GameMap(rows, cols);
        Cell[][] cells = gameMap.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = new Cell();
            }
        }
        Arrays.stream(OrganismTypes.values()).forEach(e -> {
            cells[Randomizer.getZeroToBound(rows)][Randomizer.getZeroToBound(cols)]
                    .getResidents()
                    .put(String.valueOf(e), Stream.generate(() -> organismFactory.getNewOrganism(e))
                            .limit(Settings.START.getValue())
                            .collect(Collectors.toSet()));
        });
        Arrays.stream(OrganismTypes.values()).forEach(types -> {
            Stream.generate(() -> organismFactory.getNewOrganism(types))
                    .limit(Settings.valueOf("COUNT_OF_" + types.getName().toUpperCase()).getValue())
                    .forEach(o -> {
                        cells[Randomizer.getZeroToBound(rows)][Randomizer.getZeroToBound(cols)]
                                .getResidents()
                                .computeIfAbsent(types.getName(), s -> new HashSet<>())
                                .addAll(Stream.of(o).collect(Collectors.toSet()));
                    });
        });
        return gameMap;
    }
}
