package com.javarush.island.sheff;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.entities.organisms.Organism;
import com.javarush.island.sheff.repository.*;

import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        OrganismFactory organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        GameMap gameMap = gameMapCreator.createRandomStartGameMap();

        System.out.println("Линий: " + gameMap.getCells().length);
        int counterRows = -1;

        for (Cell[] rows : gameMap.getCells()) {
            System.out.println("Линия: " + ++counterRows + " Колонок: " + rows.length);
            int counterCols = -1;

            for (Cell cells : rows) {
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

        int bear = Settings.COUNT_OF_BEAR.getValue();
        int start = Settings.START.getValue();
        int eagle = Settings.COUNT_OF_EAGLE.getValue();
        System.out.println(bear + " " + start + " " + eagle);

        Organism organismBear = organismFactory.getNewOrganism(OrganismTypes.BEAR);
        System.out.println(organismBear.getLimit().getMaxCount());

    }
}
