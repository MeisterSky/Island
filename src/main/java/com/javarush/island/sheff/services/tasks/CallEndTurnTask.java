package com.javarush.island.sheff.services.tasks;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.*;

public class CallEndTurnTask extends Task {

    public CallEndTurnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Boolean call() {

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> !organisms.isDead())
                .forEach(Organism::endTurn));

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .forEach((s, organisms) -> organisms.removeIf(Organism::isDead)));

        System.out.println("Конец хода");

        return true;
    }
}
