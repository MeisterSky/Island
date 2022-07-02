package com.javarush.island.sheff.services.tasks;

import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;

import java.util.Arrays;
import java.util.Collection;

public class CallSelectOfDirectionTask extends Task {

    public CallSelectOfDirectionTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Boolean call() {
        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> organisms instanceof Moving && !organisms.isDead() && organisms.getSteps() > 0)
                .forEach(organisms -> ((Moving) organisms).selectOfDirection(cell.getAdjacentCells())));

        System.out.println("Выбрали направление");

        return true;
    }
}
