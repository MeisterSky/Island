package com.javarush.island.sheff.services.tasks;

import com.javarush.island.sheff.entities.map.Cell;

import java.util.concurrent.Callable;

public abstract class Task implements Callable<Boolean> {

    protected Cell[] cells;
    @Override
    public abstract Boolean call();
}
