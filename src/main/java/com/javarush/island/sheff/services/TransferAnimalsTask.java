package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TransferAnimalsTask implements Task {

    Cell[] cells;
    Set<Organism> organismSet;

    public TransferAnimalsTask(Cell[] cells, Set<Organism> organismSet) {
        this.cells = cells;
        this.organismSet = organismSet;
    }

    @Override
    public Long call() {
        Arrays.stream(cells).forEach(cell -> cell.getNewResidents()
                .forEach((s, organisms) -> organisms.addAll(organismSet
                        .stream()
                        .filter(organism -> organism.getName().equals(s) && organism.getLocation().getCol() == cell.getCol())
                        .collect(Collectors.toSet()))));

        System.out.println("Переместились");
        return Thread.currentThread().getId();
    }
}