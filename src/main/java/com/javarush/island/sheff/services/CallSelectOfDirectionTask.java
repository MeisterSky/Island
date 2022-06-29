package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;

import java.util.Arrays;
import java.util.Collection;

public class CallSelectOfDirectionTask implements Task {

    Cell[] cells;

    public CallSelectOfDirectionTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public void run() {
        Arrays.stream(cells).forEach(cell -> {
            cell.getResidents()
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .filter(organisms -> organisms instanceof Moving && !organisms.isDead() && organisms.getSteps() > 0)
                    .forEach(organisms -> ((Moving) organisms).selectOfDirection(cell.getAdjacentCells()));
        });
        System.out.println("Выбрали направление");
    }
}
