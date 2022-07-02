package com.javarush.island.sheff.services.tasks;

import com.javarush.island.sheff.entities.abstraction.behavior.Eating;
import com.javarush.island.sheff.entities.map.Cell;

import java.util.Arrays;
import java.util.Collection;

public class CallEatTask extends Task {

        public CallEatTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Boolean call() {

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> organisms instanceof Eating && !organisms.isDead() && organisms.getWeight() < organisms.getLimit().getMaxWeight())
                .forEach(organism -> {
                    if (!organism.isDead()) {
                        ((Eating) organism).eat(cell.getResidents());
                    }
                }));

        System.out.println("Поели");

        return true;
    }
}
