package com.javarush.island.sheff.entities.map;

import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.repository.OrganismFactory;

import java.util.*;
import java.util.stream.Collectors;

public class GameMap {
    private final Cell[][] cells;
    private int rows, cols;

    public GameMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public void initialize(OrganismFactory organismFactory) {
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                cells[row][col] = new Cell(row, col, organismFactory.getNewOrganismNamesMap());
            }
        }
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                cells[row][col].updateNextCell(this, row, col);
            }
        }
    }

    public void updateCells(OrganismFactory organismFactory) {
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                cells[row][col].updateResidents(organismFactory.getNewOrganismNamesMap());
            }
        }
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

    public Set<Organism> getAllOrganisms() {
        Set<Organism> allOrganisms = new HashSet<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                allOrganisms.addAll(cell.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet()));
            }
        }
        return allOrganisms;
    }
}
