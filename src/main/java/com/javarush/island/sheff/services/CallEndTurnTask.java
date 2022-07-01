package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.*;

public class CallEndTurnTask implements Task {

    Cell[] cells;

    public CallEndTurnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Long call() {

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> !organisms.isDead())
                .forEach(Organism::endTurn));

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .forEach((s, organisms) -> organisms.removeIf(Organism::isDead)));

        System.out.println("Конец хода");

        return Thread.currentThread().getId();
    }
}
