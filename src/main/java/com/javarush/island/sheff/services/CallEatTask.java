package com.javarush.island.sheff.services;

import com.javarush.island.sheff.entities.map.Cell;

public class CallEatTask implements Task {

    Cell[] cells;

    public CallEatTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public void run() {

        System.out.println("Поели");
    }
}
