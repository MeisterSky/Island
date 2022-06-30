package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;

public class CallEndTurnTask implements Task {

    Cell[] cells;

    public CallEndTurnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Long call() {

        System.out.println("Конец хода");

        return Thread.currentThread().getId();
    }
}
