package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.abstraction.behavior.Moving;
import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;

import java.util.Arrays;
import java.util.Collection;

public class WorkerMovingAnimals {

    GameMap gameMap;

    public void movingAnimals(Cell[] cells, GameMap gameMap) {
        this.gameMap = gameMap;
        Arrays.stream(cells).forEach(cell -> {
            cell.getResidents()
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .filter(organisms -> organisms instanceof Moving && organisms.getSteps() > 0)
                    .forEach(organisms -> ((Moving) organisms).move(cell.getAdjacentCells()));
        });
    }
}
