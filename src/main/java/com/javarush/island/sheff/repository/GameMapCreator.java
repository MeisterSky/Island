package com.javarush.island.sheff.repository;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.util.Randomizer;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record GameMapCreator(OrganismFactory organismFactory) {

    public GameMap createRandomStartGameMap() {
        int rows = Settings.ROWS.getValue();
        int cols = Settings.COLS.getValue();
        int startingQuantity = Settings.START.getValue();
        GameMap gameMap = new GameMap(rows, cols);

        Cell[][] cells = gameMap.getCells();
        IntStream.range(0, cells.length)
                .parallel()
                .forEach(row -> Arrays.setAll(cells[row], col -> new Cell(organismFactory.getOrganismNamesMap())));


        Arrays.stream(OrganismTypes.values()).forEach(organismTypes -> {

            cells[Randomizer.getZeroToBound(rows)][Randomizer.getZeroToBound(cols)]
                    .getResidents()
                    .get(organismTypes.getName())
                    .addAll(Stream.generate(() -> organismFactory.getNewOrganism(organismTypes))
                            .limit(Integer.min(startingQuantity, organismFactory.getPrototypeOrganismLimit(organismTypes).getMaxCount()))
                            .collect(Collectors.toSet()));

            Stream.generate(() -> organismFactory.getNewOrganism(organismTypes))
                    .limit(Settings.valueOf("COUNT_OF_" + organismTypes.getName().toUpperCase())
                            .getValue() - Integer.min(startingQuantity, organismFactory.getPrototypeOrganismLimit(organismTypes).getMaxCount()))
                    .forEach(organism -> {
                        Cell[] arr = Arrays.stream(cells)
                                .flatMap(Arrays::stream)
                                .filter(cell -> cell.getResidents()
                                        .get(organismTypes.getName()).size() < organism.getLimit().getMaxCount())
                                .toArray(Cell[]::new);
                        arr[Randomizer.getZeroToBound(arr.length)]
                                .getResidents()
                                .get(organismTypes.getName())
                                .add(organism);
                    });
        });

        return gameMap;
    }
}
