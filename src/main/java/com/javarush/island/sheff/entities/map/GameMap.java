package com.javarush.island.sheff.entities.map;

import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameMap {
    private final Cell[][] cells;

    public GameMap(int rows, int cols) {
        this.cells = new Cell[rows][cols];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return cells.length;
    }

    public int getCols() {
        return cells[0].length;
    }

    public Set<Organism> getAll() {
        Set<Organism> all = new HashSet<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                all.addAll(cell.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet()));
            }
        }
        return all;
    }
}
