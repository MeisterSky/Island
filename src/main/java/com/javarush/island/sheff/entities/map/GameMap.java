package com.javarush.island.sheff.entities.map;

import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.repository.OrganismFactory;
import com.javarush.island.sheff.repository.OrganismTypes;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class GameMap {
    private final Cell[][] cells;
    private final int rows;
    private final int cols;
    private int transferCount;
    private OrganismFactory organismFactory;

    public GameMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public void initialize(OrganismFactory organismFactory) {
        this.organismFactory = organismFactory;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col, organismFactory.getNewOrganismNamesMap(), organismFactory.getNewOrganismNamesMap());
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].updateNextCell(this, row, col);
            }
        }
        transferCount = getAllOrganismsSet()
                .stream()
                .max((o1, o2) -> Math.max(o1.getLimit().getMaxSpeed(), o2.getLimit().getMaxSpeed()))
                .orElse(organismFactory.getNewOrganism(OrganismTypes.HORSE)).getLimit().getMaxSpeed();

    }

    public void updateCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].updateResidents(organismFactory.getNewOrganismNamesMap());
            }
        }
    }

    public int getTransferCount() {
        return transferCount;
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

    public ConcurrentMap<Integer, HashSet<Organism>> getAllOrganismsMap() {
        ConcurrentMap<Integer, HashSet<Organism>> allOrganisms = new ConcurrentHashMap<>();

        for (int i = 0; i < rows; i++) {
            allOrganisms.put(i, new HashSet<>());
        }

        for (int i = 0; i < rows; i++) {
            Cell[] cell = cells[i];
            for (int j = 0; j < cols; j++) {
                Cell cell1 = cell[j];
                cell1.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .forEach(organism -> allOrganisms.get(organism.getLocation().getRow()).add(organism));
                System.out.println("Собрана ячейка " + i + ":" + j);
            }
            System.out.println("Собрана линия " + i);
        }
        System.out.println("Животные собраны");
        return allOrganisms;
    }

    public Set<Organism> getAllOrganismsSet() {
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

    @Override
    public String toString() {
        return "000";
    }
}
