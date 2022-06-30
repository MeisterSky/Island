package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;

import java.util.Arrays;
import java.util.Collection;

public class TransferAnimalsTask implements Task {

    Cell[] cells;

    public TransferAnimalsTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Long call() {
        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> organisms instanceof Moving && organisms.getSteps() > 0)
                .forEach(organisms -> ((Moving) organisms).selectOfDirection(cell.getAdjacentCells())));

        System.out.println("Переместились");
        return Thread.currentThread().getId();
    }
}