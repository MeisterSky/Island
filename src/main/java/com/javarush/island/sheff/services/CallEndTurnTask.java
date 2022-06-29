package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;

public class CallEndTurnTask implements Task {

    Cell[] cells;

    public CallEndTurnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public void run() {
        System.out.println("Конец хода");
    }
}
