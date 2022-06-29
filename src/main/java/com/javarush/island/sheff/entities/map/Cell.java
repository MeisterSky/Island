package com.javarush.island.sheff.entities.map;

import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.repository.OrganismTypes;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Cell {

    private final int row;
    private final int col;

    private final Map<String, HashSet<Organism>> residents;
    private final List<Cell> adjacentCells = new ArrayList<>();

    public Cell(int row, int col, Map<String, HashSet<Organism>> residents) {
        this.row = row;
        this.col = col;
        this.residents = residents;
    }

    public void updateNextCell(GameMap map, int row, int col) {
        Cell[][] cells = map.getCells();
        if (row > 0) adjacentCells.add(cells[row - 1][col]);
        if (col > 0) adjacentCells.add(cells[row][col - 1]);
        if (row < map.getRows() - 1) adjacentCells.add(cells[row + 1][col]);
        if (col < map.getCols() - 1) adjacentCells.add(cells[row][col + 1]);
    }

    @Override
    public String toString() {
        return "" + residents.entrySet()
                .stream()
                .filter(stringHashSetEntry -> stringHashSetEntry.getValue().size() > 0)
                .map((entry) -> OrganismTypes.valueOf(entry.getKey().toUpperCase()).getIcon()
                        + ":" + entry.getValue().size())
                .collect(Collectors.joining("\n"));

    }
}
