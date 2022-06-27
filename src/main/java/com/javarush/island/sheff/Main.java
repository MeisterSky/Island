package com.javarush.island.sheff;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.repository.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        OrganismFactory organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        GameMap gameMap = gameMapCreator.createRandomStartGameMapFromSettings();

        for (Cell[] row : gameMap.getCells()) {
            for (Cell cells : row) {

                Set<Organism> parents = cells.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet());

                Set<Organism> offsprings = new HashSet<>();


                for (Map.Entry<String, HashSet<Organism>> organismValues : cells.getResidents().entrySet()) {
                    if (organismValues.getValue().size() > 0) {
                        for (Organism organisms : organismValues.getValue()) {

                            System.out.println("Рождение нового организма у " + organisms);
                        }
                    }
                }
            }

        }

        System.out.println("Линий: " + gameMap.getCells().length);
        int counterRows = -1;

        for (Cell[] row : gameMap.getCells()) {
            System.out.println("Линия: " + ++counterRows + " Колонок: " + row.length);
            int counterCols = -1;

            for (Cell cells : row) {
                System.out.println("Колонка: " + ++counterCols + ", Видов организмов: " + cells.getResidents().size());

                for (Map.Entry<String, HashSet<Organism>> organismValues : cells.getResidents().entrySet()) {
                    if (organismValues.getValue().size() > 0)
                        System.out.println("В ячейке " + counterRows + ":" + counterCols + " Организмов " + organismValues.getKey() + ": " + organismValues.getValue().size());

                    for (Organism organisms : organismValues.getValue()) {
                        System.out.println("Организм " + organisms);
                    }
                }
            }

        }
        System.out.println("Всего организмов: " + gameMap.getAll().size());

        Organism organismBear = organismFactory.getNewOrganism(OrganismTypes.BEAR);
        System.out.println(organismBear.getLimit().getMaxCount());

    }
}
