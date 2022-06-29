package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;
import com.javarush.island.sheff.entities.organisms.Organism;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOneCell(cell);
                } catch (Exception e) {
                    //TODO replace it -> throw...
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
                    System.exit(0);
                }
            }
        }
    }

    private void processOneCell(Cell cell) {

        //run tasks
        //see CQRS pattern or CommandBus pattern and Producer-Consumer problem.
        //This cycle can to run in other thread or threads (pool)
        tasks.forEach(Task::doTask);
        tasks.clear();
    }
}

