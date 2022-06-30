package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CallSpawnTask implements Task {

    Cell[] cells;

    public CallSpawnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Long call() {
        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> !organisms.isDead() && organisms.isFemaleGender() && organisms.isCanBreed())
                .map(Organism::spawn)
                .flatMap(Set::stream)
                .collect(Collectors.toSet())
                .forEach(organisms -> {
                    if (cell.getResidents()
                            .get(organisms.getName())
                            .size() < organisms.getLimit().getMaxCount())
                        cell.getResidents()
                                .get(organisms.getName())
                                .add(organisms);
                }));
        System.out.println("Размножились");

        return Thread.currentThread().getId();
    }
}
