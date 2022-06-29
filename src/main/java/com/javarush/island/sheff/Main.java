package com.javarush.island.sheff;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.repository.*;
import com.javarush.island.sheff.services.CallSelectOfDirectionTask;
import com.javarush.island.sheff.view.SimulatorView;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        OrganismFactory organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        GameMap gameMap = gameMapCreator.createRandomStartGameMapFromSettings();

//        for (Cell[] row : gameMap.getCells()) {
//            for (Cell cells : row) {
//
//                Set<Organism> parents = cells.getResidents()
//                        .values()
//                        .stream()
//                        .flatMap(Collection::stream)
//                        .collect(Collectors.toSet());
//
//                Set<Organism> offsprings = new HashSet<>();
//
//
//                for (Map.Entry<String, HashSet<Organism>> organismValues : cells.getResidents().entrySet()) {
//                    if (organismValues.getValue().size() > 0) {
//                        for (Organism organisms : organismValues.getValue()) {
//
//                            System.out.println("Рождение нового организма у " + organisms);
//                        }
//                    }
//                }
//            }
//
//        }

        System.out.println("Линий: " + gameMap.getCells().length);
        int counterRows = -1;

//        for (Cell[] row : gameMap.getCells()) {
//            System.out.println("Линия: " + ++counterRows + " Колонок: " + row.length);
//
//            for (Cell cells : row) {
//                System.out.println("Колонка: " + cells.getRow() + ":" + cells.getCol() + ", Видов организмов: " + cells.getResidents().size());
//
//                for (Map.Entry<String, HashSet<Organism>> organismValues : cells.getResidents().entrySet()) {
//                    if (organismValues.getValue().size() > 0)
//                        System.out.println("В ячейке " + cells.getRow() + ":" + cells.getCol() + " Организмов " + organismValues.getKey() + ": " + organismValues.getValue().size());
//
//                    for (Organism organisms : organismValues.getValue()) {
//                        System.out.println("Организм " + organisms);
//                    }
//                }
//            }
//
//        }

        CallSelectOfDirectionTask callSelectOfDirectionTask = new CallSelectOfDirectionTask((Arrays.stream(gameMap.getCells())
                .flatMap(Arrays::stream).toArray(Cell[]::new)));
        callSelectOfDirectionTask.run();


//        Arrays.stream(gameMap.getCells())
//                .flatMap(Arrays::stream)
//                .forEach(cell -> {
//                    cell.getResidents()
//                            .values()
//                            .stream()
//                            .flatMap(Collection::stream)
//                            .forEach(organism -> {
//                                if (organism instanceof Moving && organism.getSteps() > 0) {
//                                    ((Moving) organism).move(cell.getAdjacentCells());
//                                }
//                            });
//                });

        System.out.println("Всего организмов: " + gameMap.getAllOrganisms().size());

        SimulatorView simulatorView = new SimulatorView();
        simulatorView.getView(gameMap);
        System.out.println(gameMap.getCells()[0][0].toString());

    }
}
